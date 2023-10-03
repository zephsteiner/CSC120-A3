import java.util.Random;
import java.util.Scanner;

class Conversation {


  /**
   * Takes in a string and scans it for certain words, which it then edits
   * if they are found. 
   * 
   * @param  s          any string
   * @return words_out  the interpreted string
   */
  public static String interpretPhrase(String s) {
    String[] orig = new String[]{"I",  "you", "You", "my",   "My",   "your", "Your", "are", "Are", "am",  "Am",  "me",  "Me", "I'm"};
    String[] mirrors = new String[]{"you", "I",  "I",   "your", "Your", "my",   "My",   "am",  "Am",  "are", "Are", "you", "You", "You're"};
    String[] words = new String[40];
    words = s.split(" ");
    for (int i = 0; i < words.length; i++) {
      for (int k = 0; k < orig.length; k++) {
        if (words[i].compareTo(orig[k]) == 0) {
          words[i] = mirrors[k];
          break;
        }
      }
    }
    String words_out = String.join(" ", words);
    return words_out;
    }

  public static void main(String[] arguments) {
    String[] rand_responses = {"Mmm.", "Neat!", "Uh-huh.", "Okay.", "Mm-hm.", "Ah."};
    Random response_generator = new Random(); // so yr able to generate a key for random response

    Scanner input = new Scanner(System.in);
    System.out.print("How many rounds of conversation are you feeling? ");
    int num_rounds = input.nextInt();
    input.nextLine();
    String transcript[] = new String[(2*(num_rounds)+2)];
    transcript[0] = "What's on your mind?";
    transcript[2*(num_rounds)+1] = "See ya!";
    
    System.out.println("What's on your mind?");
    for (int i = 0; i < num_rounds; i++) {
      String user_input_phrase =  input.nextLine();
      transcript[(2*(i))+1] = user_input_phrase;
      String modified_phrase = Conversation.interpretPhrase(user_input_phrase); 
      if (modified_phrase.compareTo(user_input_phrase)==0) {
        int key = response_generator.nextInt(6);
        String rand_resp = rand_responses[key];
        transcript[(2*(i))+2]= rand_resp;
        System.out.println(rand_resp);
      }
      else {
        String mod_resp = modified_phrase + "?";
        transcript[(2*(i))+1]= mod_resp;
        System.out.println(mod_resp);
      }

    }
    System.out.println("See ya!\n\nTranscript:");
    for (String elem : transcript) {
      System.out.println(elem);
    }
    input.close();
  }
}
