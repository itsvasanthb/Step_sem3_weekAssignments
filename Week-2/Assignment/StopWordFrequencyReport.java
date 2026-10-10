
import java.util.*;

class StopWordFrequencyReport {
    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        HashMap<String, Integer> frequency = new HashMap<>();

        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        for (String word : words) {
            boolean stop = false;

            for (String s : stopWords) {
                if (word.equals(s))
                    stop = true;
            }

            if (!stop && !word.isEmpty())
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<String> result = new ArrayList<>(frequency.keySet());
        result.sort((a, b) -> frequency.get(b) - frequency.get(a));

        for (String word : result)
            System.out.println(word + ": " + frequency.get(word));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter feedback:");
        String feedback = sc.nextLine();
        printFilteredWordFrequency(feedback);
    }
}
