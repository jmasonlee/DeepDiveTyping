package org.teachingkidsprogramming.typingdeepdive;

import com.spun.util.WindowUtils;
import com.spun.util.io.FileUtils;
import org.teachingkidsprogramming.typingdeepdive.Shark.PlayState;
import org.teachingkidsprogramming.typingdeepdive.analytics.GameAnalytics;
import org.teachingkidsprogramming.typingdeepdive.tests.WordType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DeepDiveTypingGame implements PlayStateListener {
    public final WordType type;
    public JPanel view;
    public ArrayList<Actor> actors = new ArrayList<Actor>();
    public Score score;
    public Timer timer;
    public Actor selected;
    public GameAnalytics analytics;

    public DeepDiveTypingGame(WordType type) {
        this.type = type;
        this.view = new DeepDiveTypingView(this, KeyProcessor.createKeyProcessor(this));
    }

    public DeepDiveTypingGame() {
        this(WordType.ENGLISH);
    }

    private static void OpenWindow(JPanel view) {
        JFrame test = new JFrame("Deep Dive Typing");
        test.getContentPane().add(view);
        WindowUtils.testFrame(test, true);
    }

    public static void main(String[] args) {
        new DeepDiveTypingGame().launchWindow();
    }

    private void launchWindow() {
        showStartPanel();
        OpenWindow(view);
    }

    private void showStartPanel() {
        actors.add(new StartGame(this));
        startClock();
    }

    private void startClock() {
        int delay = 1000 / 25; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                advanceClock();
                view.repaint();
            }
        };
        timer = new Timer(delay, taskPerformer);
        timer.start();
    }

    public void advanceClock() {
        for (Actor shark : actors.toArray(new Actor[0])) {
            shark.advanceClock();
        }
    }

    public void processLetter(char letter) {
        if (selected != null) {
            selected.processLetter(letter);
            return;
        }
        for (Actor shark : actors.toArray(new Actor[0])) {
            if (selected == null) {
                if (shark.processLetter(letter)) {
                    return;
                }
            }
        }
    }

    @Override
    public void playStateChanged(Shark shark) {
        PlayState state = shark.getState();
        switch (state) {
            case Killed:
                removeShark(shark);
                break;
            case Killing:
                actors.add(new GameOver(this));
                break;
            case Selected:
                selected = shark;
                break;
            default:
                break;
        }
    }

    public void removeShark(Shark shark) {
        score.scoreKill(shark);
        remove(shark);
    }

    public void remove(Actor shark) {
        actors.remove(shark);
        selected = null;
        if (isEmpty()) {
            actors.add(new SharkBatch(this));
        }
    }

    private boolean isEmpty() {
        return actors.isEmpty() || (actors.size() == 1 && actors.get(0) instanceof Diver);
    }

    public void addDiver() {
        boolean contains = false;
        for (Actor a : actors) {
            contains |= a instanceof Diver;
        }
        if (!contains) {
            actors.add(new Diver());
        }
    }

    public void start() {
        analytics = new GameAnalytics();
        score = new Score();
        actors.clear();
        selected = null;
        actors.add(new SharkBatch(this));
        actors.add(new Diver());
    }

    public void writeAnalytics() {
        try {
            FileUtils.writeFile(new File(".analytics.json"), "game:" + analytics);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }
}
