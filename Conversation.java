import java.util.Scanner;
/**
 * Assignment 3
 * @author CSC120: Section3 Feiran Chang
 */
class Conversation {
  public static void main(String[] arguments) {
    // You will start the conversation here.

    // asking for rounds
    Scanner reader = new Scanner(System.in);
    System.out.println("How many rounds?");
    int rounds = reader.nextInt();
    reader.nextLine();

    int arraySize = 2 * rounds + 2;
    System.out.println("arraySize: " + arraySize); //delete2
    String[] transcription = new String[arraySize];

    // Ask Hi there...
    System.out.println("Hi there! What's on your mind?");
    transcription[0] = ("Hi there! What's on your mind?");
    System.out.println("transcription[0]: " + transcription[0]); //delete2

    // rounds(for loop)
    String input = "";
    String output = "";

    for (int i = 0; i < rounds; i++) {
      input = reader.nextLine();
      transcription[2*i+1] = (input);
      System.out.println("i:" + (i+1)); //delete
      output = mirrorWord(input);
      if (output.equals(input)) {
        output = ("Mmm-hm");
      }
      output = changePunctuatio(output);
      transcription[2*i+2] = output;
      System.out.println(output);
      System.out.println("output:" + output); //delete
      System.out.println("transcription[2*i]: " + i + transcription[2*i+1]); //delete2
      System.out.println("transcription[2*i+1]: " + i+ transcription[2*i+2]); //delete2
    }

    //Ends: see al
    reader.close();
    System.out.println("See ya!");
    transcription[arraySize-1] = ("See ya!");

    System.out.println("TRANSCRIPTION:");
    for (int j = 0; j < arraySize; j++) {
      System.out.println((j+1) + ": " + transcription[j]);
    }
  }

  /**
   * Replace words like pronouns
   * @param s String that needs to be changed
   * @return String that has been changed 
   */
  public static String mirrorWord(String s) {
    String[] splitWord = splitString(s);
    String[] keyWord = new String[] {"I", "me", "am", "you", "my", "your", "are"};
    String[] mirrorWord = new String[] {"you", "you", "are", "I", "your", "my", "am"};
    int size = keyWord.length;
    for (int j = 0; j < splitWord.length; j++) {
      String split = splitWord[j];
      System.out.println("split: " + j + split); //delete2
      for (int i = 0; i < size; i++) {
        String key = keyWord[i];
        System.out.println("key: " + i + key); //delete2
        if (split.equals(key)) {
          String mirror = mirrorWord[i];
          s = s.replace(split, mirror);
          System.out.println("s replace: " + s); //delete2
          break;
        }
      }
    }
    return s;
  }

  
/**
 * Split a string by space and period if needed
 * @param s String needs to be splitted
 * @return String array 
 */
  public static String[] splitString(String s) {
    String[] splitWord;
    if (s.contains(".")) {
      splitWord = s.split("[ .]", 0);
      System.out.println("split size: " + splitWord.length); //delete2

    }
    else {
      splitWord = s.split("", 0); 
    }
    return splitWord;
  }

/**
 * replace period with question mark
 * @param s the string needs to be changed
 * @return the string has been changed
 */
  public static String changePunctuatio(String s) {
    s.replace(".", "?");
    return s;
  }


}
