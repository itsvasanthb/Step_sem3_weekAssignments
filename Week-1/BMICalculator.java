
import java.util.Random;

class Main {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-10s %-12s %-12s %-10s %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf("%-10d %-12.2f %-12.2f %-10.2f %-15s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        double[] heights = new double[10];
        double[] weights = new double[10];

        for (int i = 0; i < 10; i++) {
            heights[i] = 1.50 + r.nextDouble() * 0.40;
            weights[i] = 45 + r.nextDouble() * 65;
        }

        printWellnessReport(heights, weights);
    }
}
