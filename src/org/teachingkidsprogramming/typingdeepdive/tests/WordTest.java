package org.teachingkidsprogramming.typingdeepdive.tests;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Function;
import java.util.function.Supplier;

import org.approvaltests.Approvals;
import org.junit.Test;
import org.lambda.functions.Function1;
import org.lambda.query.Query;
import org.teachingkidsprogramming.typingdeepdive.SharkBatch;
import org.teachingkidsprogramming.typingdeepdive.Words;

import com.spun.util.io.FileUtils;

import static org.junit.Assert.*;

public class WordTest
{
  // @Test
  public void SortWordList() throws Exception
  {
    String[] words = FileUtils.readFromClassPath(Words.class, "words.txt").split("\n");
    Function1<String, Comparable> f1 = new Function1<String, Comparable>()
    {
      @Override
      public Comparable call(String i)
      {
        return i;
      }
    };
    Query.orderBy(words, f1);
    File out = new File("c:\\temp\\words.txt");
    FileWriter writer = new FileWriter(out);
    for (String word : words)
    {
      writer.write(word + "\n");
    }
    writer.close();
  }
  // @Test
  public void testWordsByLength() throws Exception
  {
    HashMap<Integer, ArrayList<String>> words = Words.getWords();
    Approvals.verifyAll("", words.get(2));
  }

  //@Test
  public void testUnique() throws Exception
  {
    HashSet<Character> letters = new HashSet<Character>();
    for (int i = 1; i <= 26; i++)
    {
      SharkBatch.getUniqueWord(letters);
    }
    assertEquals(26, letters.size());
  }

  @Test
  public void willImportWordsAccordingToType() {
    checkImportedWordsMatchType(Words::importEnglishWords, WordType.ENGLISH);
    checkImportedWordsMatchType(Words::importFinnishWords, WordType.FINNISH);
    checkImportedWordsMatchType(Words::importHotkeys, WordType.HOTKEYS);
  }

  private void checkImportedWordsMatchType(Supplier<HashMap<Integer, ArrayList<String>>> wordSupplier, WordType wordType) {
    HashMap<Integer, ArrayList<String>> words = wordSupplier.get();

    for (Integer key : words.keySet()) {
      assertTrue(words.get(key).equals(Words.getWords(wordType).get(key)));
    }
  }
}
