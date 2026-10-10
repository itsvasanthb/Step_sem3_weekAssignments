
import java.util.Scanner;

class WordReversalEncoder {
    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            result += word.reverse().toString();

            if (i < words.length - 1)
                result += " ";
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();
        System.out.println(reverseEachWord(sentence));
    }
}
