
import java.util.*;

public class WordReverser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String reverse = new StringBuilder(s).reverse().toString();

        if (s.equals(reverse)) {
            System.out.println(reverse + " - palindrome");
        } else {
            System.out.println(reverse + " - not a palindrome");
        }

        sc.close();
    }
}
