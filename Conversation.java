import java.util.Scanner;
/**
 * Assignment 3
 * @author CSC120: Section3 Feiran Chang
 */
class Conversation {
  /**
   * The chatbot will always say "Hi there! What's on your mind?" to begin a chat
   * And "See ya!" to end a chat
   * If the user types pronounces and other key words that can be mirrored,
   * The chatbot will return a mirrored version (a period will also be replaced by a question mark).
   * If the user types something that cannot be mirrored
   * the chatbot will return "Mmm-hm" 
   * @param arguments
   */
  public static void main(String[] arguments) {
    // You will start the conversation here.

    // asking for rounds
    Scanner reader = new Scanner(System.in);
    System.out.println("How many rounds?");
    int rounds = reader.nextInt();
    reader.nextLine();

    int arraySize = 2 * rounds + 2;
    String[] transcription = new String[arraySize];

    // Ask Hi there...
    System.out.println("Hi there! What's on your mind?");
    transcription[0] = ("Hi there! What's on your mind?");
    // rounds(for loop)
    String input = "";
    String output = "";

    for (int i = 0; i < rounds; i++) {
      input = reader.nextLine();
      transcription[2*i+1] = (input);
      Boolean checkMirror = checkMirror(input);
      if (checkMirror) {
        boolean checkPunc = isPunctuation(input);
        output = mirrorWord(input);
        if (checkPunc) {
          output += "?";
        }
      }
      else {
        output = ("Mmm-hm");
      }
      output = capitalize(output);
      transcription[2*i+2] = output;
      System.out.println(output);
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
      for (int i = 0; i < size; i++) {
        String key = keyWord[i];
        if (split.equals(key)) {
          String mirror = mirrorWord[i];
          splitWord[j] = mirror;
          break;
        }
      }
    }
    s = arrayToString(splitWord);
    return s;
  }
    
  /**
   * check if a given string contains words needed to be mirrored
   * @param s string that needs to be check
   * @return T/F does the string need to be mirrored?
   */
  public static boolean checkMirror(String s) {
    String[] splitWord = splitString(s);
    int splitLen = splitWord.length;
    boolean check = false;
    String[] keyWord = new String[] {"I", "me", "am", "you", "my", "your", "are"};
    int keyLen = keyWord.length;
    for (int i =0; i<splitLen ; i++) {
      String split = splitWord[i];
      for (int j = 0; j < keyLen; j++) {
        String key = keyWord[j];
        if (split.equals(key)){
        check =true;
        break;
        }
      }
    }
    return check;
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
    }
    else {
      splitWord = s.split(" ", 0); 
    }
    return splitWord;
  }

/**
 * replace period with question mark
 * @param s the string needs to be changed
 * @return the string has been changed
 */
  public static boolean isPunctuation(String s) {
    boolean isPunctuation = false;
    if (s.contains(".")) {
      isPunctuation = true;
    }
    return isPunctuation;
  }

  /**
   * capitalize the first letter 
   * @param s the string needs to be capitalized
   * @return a string that has been capitalized
   */
  public static String capitalize(String s) {
    char firstChr = s.charAt(0);
    char newChr = Character.toUpperCase(firstChr);
    String newStr = newChr+s.substring(1);
    return newStr;
  }

  /**
   * convert a string array into string
   * @param splitWord the string array needs to be converted
   * @return the string comes from the string array
   */
  public static String arrayToString(String[] splitWord) {
    String s = "";
    for (int i = 0; i < (splitWord.length-1); i++) {
      s = s + splitWord[i] + " ";
    }
    s += splitWord[(splitWord.length-1)];
    return s;
  }


}
