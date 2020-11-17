package com.classes;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Class1 {

  private static String[] w = null;
  private static int[] r = null;

  public static void main(String[] args) {
    try {
      int n = 10;
      int countOfWords = 0;
      w = new String[n];
      r = new int[n];
      FileReader fr = new FileReader("C:/Users/Deepak/eclipse/passage.txt");
      BufferedReader bufferReader = new BufferedReader(fr);
      String text = "";
      String sentencesCombined="";
      String sz;
      ArrayList<String> sentenceList = new ArrayList<String>();
      // finding total number of words
      while ((sz = bufferReader.readLine()) != null) {
        String words[] = sz.split(" ");
        countOfWords = countOfWords + words.length;
        text = text.concat(sz);
        sentenceList.add(sz);
        sentencesCombined = sentencesCombined+sz;
      }
      String[] sentences = sentencesCombined.split("\\.");
      System.out.println("1) Number of words present in given file: " + countOfWords);
      // finding most used words and sorting it
      String[] words = text.split(" ");
      String[] uniqueLabels;
      int count = 0;
      uniqueLabels = getUniqLabels(words);
      for (int j = 0; j < n; j++) {
        r[j] = 0;
      }
      for (String l : uniqueLabels) {
        if ("".equals(l) || null == l) {
          break;
        }
        for (String s : words) {
          if (l.equals(s)) {
            count++;
          }
        }

        for (int i = 0; i < n; i++) {
          if (count > r[i]) {
            r[i] = count;
            w[i] = l;
            break;
          }
        }
        count = 0;
      }
      Arrays.sort(w);
      display(n);
      
     
      // finding last sentence that contains most used word
      System.out.println("3) last sentence that contains most used word:");
      
      
      for(int i=sentences.length-1;i>=0;i--) {
    	  if(sentences[i].contains(w[0]) ) {
    		  System.out.println(sentences[i]);
    		  break;
}


      }
      
    } catch (Exception e) {
      System.err.println("Error while accessing the file " + e.getMessage());
    }
  }

  public static void display(int n) {
    System.out.println("2) repeated words in sorted order");
    for (int k = 0; k < n; k++) {
      System.out.println(w[k] + "    :" + +r[k]);
    }
  }

  private static String[] getUniqLabels(String[] keys) {
    String[] uniqueKeys = new String[keys.length];

    uniqueKeys[0] = keys[0];
    int uniqueKeyIndex = 1;
    boolean keyExists = false;

    for (int i = 1; i < keys.length; i++) {
      for (int j = 0; j <= uniqueKeyIndex; j++) {
        if (keys[i].equals(uniqueKeys[j])) {
          keyExists = true;
        }
      }

      if (!keyExists) {
        uniqueKeys[uniqueKeyIndex] = keys[i];
        uniqueKeyIndex++;
      }
      keyExists = false;
    }
    return uniqueKeys;
  }

}

