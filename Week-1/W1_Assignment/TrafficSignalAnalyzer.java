
import java.util.Scanner;

class TrafficSignalAnalyzer {
    static void findLongestStreak(String signalLog) {
        if (signalLog.length() == 0) {
            System.out.println("No Signal Readings");
            return;
        }

        char color = signalLog.charAt(0);
        char longestColor = color;
        int count = 1;
        int max = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == color) {
                count++;
            } else {
                color = signalLog.charAt(i);
                count = 1;
            }

            if (count > max) {
                max = count;
                longestColor = color;
            }
        }

        System.out.println("Longest Streak: '" + longestColor +
                "' repeated " + max + " times");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);
    }
}
