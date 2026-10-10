
import java.util.*;

abstract class Question {
    String correct;
    String answer;
    double points;

    Question(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    abstract double grade();
    abstract String getType();
}

class MCQ extends Question {
    MCQ(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return correct.equalsIgnoreCase(answer) ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TF extends Question {
    TF(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return correct.equalsIgnoreCase(answer) ? points : 0;
    }

    String getType() {
        return "TF";
    }
}

class Essay extends Question {
    Essay(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        String[] words = correct.split(",");
        int count = 0;

        for (String word : words) {
            if (answer.toLowerCase().contains(word.trim().toLowerCase()))
                count++;
        }

        if (count >= 2)
            return points * 0.75;
        else if (count == 1)
            return points * 0.50;
        else
            return 0;
    }

    String getType() {
        return "ESSAY";
    }
}

class QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");
            String type = line.substring(0, line.indexOf(" ")).trim();

            String correct = parts[2].trim();
            String answer = parts[4].trim();
            double points = Double.parseDouble(parts[5].trim());

            Question q;

            if (type.equals("MCQ"))
                q = new MCQ(correct, answer, points);
            else if (type.equals("TF"))
                q = new TF(correct, answer, points);
            else
                q = new Essay(correct, answer, points);

            double score = q.grade();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
