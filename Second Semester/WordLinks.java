import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;




public class WordLinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
           String wordsInputted;
           do {
               System.out.println("Enter a comma separated list of words (or an empty list to quit):");
               wordsInputted = scanner.nextLine();
               if (wordsInputted.isEmpty()) {
                   System.out.println("Goodbye.");
                   finished = true;
               } else if (isWordChain(readWordList(wordsInputted))) {
                   System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
               } else {
                   System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
               }
           } while (!finished);
           scanner.close();
       }


       public static ArrayList<String> readDictionary() {
           File file = new File("words.txt");
           Scanner input = null;
           try {
               input = new Scanner(file);
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           }
           ArrayList<String> list = new ArrayList<>();
           while (true) {
               assert input != null;
               if (!input.hasNextLine())
                   break;
               list.add(input.nextLine());
           }
           return list;
       }


       public static String[] readWordList(String listOfWords) {
           return listOfWords.split(", ");
       }


       public static boolean isUniqueList(String[] inputtedList) {
           if (inputtedList != null) {
               boolean isUnique;
               for (int i = 0; i < inputtedList.length - 1; i++) {
                   for (int i2 = i + 1; i2 < inputtedList.length; i2++) {
                       isUnique = !inputtedList[i].equals(inputtedList[i2]);
                       if (!isUnique) {
                           return false;
                       }
                   }
               }
               return true;
           }
           return false;
       }


       public static boolean isEnglishWord(String[] wordList) {
           for (String wordFound : wordList) {
               int word = Arrays.binarySearch(wordList, wordFound);
               if (word < 0) {
                   return false;
               }
           }
           return true;

       }


       public static boolean isDifferentByOne(String compareWord, String checkWithWord) {
           char[] firstWord = compareWord.toLowerCase().toCharArray();
           char[] secondWord = checkWithWord.toLowerCase().toCharArray();
           if (firstWord.length != secondWord.length)
               return false;
           int counter = 0;
           for (int i = 0; i < firstWord.length; i++) {
               if (firstWord[i] != secondWord[i]) {
                   counter++;
               }
           }
           return counter == 1;
       }


       public static boolean isWordChain(String[] listOfWords) {
           String[] dictionary = readDictionary().toArray(new String[0]);
           boolean correctWordLink = true;
           if (isUniqueList(listOfWords)) {
               for (int i = 0; i < listOfWords.length; i++) {
                   if (!isEnglishWord(dictionary)) {
                       correctWordLink = false;
                   }
                   if (i <= listOfWords.length - 2) {
                       if (!isDifferentByOne(listOfWords[i], listOfWords[i + 1])) {
                           correctWordLink = false;
                       }
                   }
               }
           }
           return correctWordLink;
       }
}






