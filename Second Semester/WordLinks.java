/* SELF ASSESSMENT

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: yes i have the correct method name
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: yes my method reads from the words.txt file
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: it returns it in arraylist form

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: yes, my method has the correct definitions
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: my method reads the the file and returns it as an arraylist

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: i have the correct method definition
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: my method has a compare word and compares everything with it
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: it exits the loop and returns false if a non-unique word is found
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: yes my program does that

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: yes, i have the correct method definition
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: yes, my method uses the library class
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: yes,me method retuns false if value < 0

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: i have the correct method definition
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: yes, my program compares characters for one difference

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: yes, i have the correct definition
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: yes my program calls all the methods and makes use of them

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: all the words are read from word.txt using java.io*
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: yes, the user is asked for input and if it is entered it calls isWordChain

 Total Mark out of 100 (Add all the previous marks): 100
*/



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






