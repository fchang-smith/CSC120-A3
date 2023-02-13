import java.util.Scanner;

class Conversation {
  public static void main(String[] arguments) {
    // You will start the conversation here.

    Scanner reader = new Scanner(System.in);
    System.out.println("How many rounds?");
    int rounds = reader.nextInt();

    int arraySize = 2 * rounds + 2;
    System.out.println("arraySize: " + arraySize); //delete2
    String[] transcription = new String[arraySize];

    // round 1
    System.out.println("Hi there! What's on your mind?");
    String answer = reader.nextLine();
    transcription[0] = ("Hi there! What's on your mind?");
    transcription[1] = (answer);
    System.out.println("transcription[0]: " + transcription[0]); //delete2
    System.out.println("transcription[1]: " + transcription[1]); //delete2

    // round 2+
    for (int i = 1; i < rounds; i++) {
      System.out.println("i:" + i); //delete
      String question = mirrorWord(answer);
      System.out.println("question:" + question); //delete
      if (question.equals(answer)) {
        question = ("Mmm-hm");
      }
      System.out.println(question);
      answer = reader.nextLine();
      System.out.println("here"); //delete
      transcription[2 * i + 1] = question;
      transcription[2 * i + 2] = answer;
    }

    System.out.println("See ya!");
    transcription[arraySize-1] = ("See ya!");
    for (int j = 0; j < arraySize; j++) {
      System.out.println(transcription[j]);
    }
    

    

  }
  public static String mirrorWord(String s) {
    String[] splitWord = s.split(" ", 0);
    String[] keyWord = new String[] {"I", "me", "am", "you", "my", "your"};
    String[] mirrorWord = new String[] {"you", "you", "are", "I", "your", "my"};
    int size = keyWord.length;
    boolean check = false;
    for (int j = 0; j < splitWord.length; j++) {
      for (int i = 0; i < size; i++) {
        String key = keyWord[i];
        check = s.contains(key);
        if (check == true) {
          String replace = mirrorWord[i];
          s = s.replace(key, replace);
          break;
        }
      }
    }
    return s;
  }
}
