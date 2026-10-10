
import java.util.Scanner;

class WordLengthProfiler {
    static void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            int length = word.replaceAll("[^a-zA-Z0-9]", "").length();

            if (length == 0)
                continue;
            else if (length <= 4)
                shortCount++;
            else if (length <= 8)
                mediumCount++;
            else
                longCount++;
        }

        System.out.println("Short: " + shortCount +
                " | Medium: " + mediumCount +
                " | Long: " + longCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        classifyWordLengths(review);
    }
}
