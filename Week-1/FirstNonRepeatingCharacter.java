
import java.util.Scanner;

class Main {
    static char findFirstNonRepeatingChar(String text) {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (text.indexOf(ch) == text.lastIndexOf(ch))
                return ch;
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0')
            System.out.println("No Non-Repeating Character Found");
        else
            System.out.println("First Non-Repeating Character: '" + result + "'");
    }
}
