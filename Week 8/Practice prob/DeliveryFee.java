
import java.util.*;

abstract class Delivery {
    double weight, distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculate();
    abstract String getType();
}

class Standard extends Delivery {
    Standard(double w, double d) {
        super(w, d);
    }

    double calculate() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }

    String getType() {
        return "STANDARD";
    }
}

class Express extends Delivery {
    Express(double w, double d) {
        super(w, d);
    }

    double calculate() {
        return 15 + weight + 0.20 * distance;
    }

    String getType() {
        return "EXPRESS";
    }
}

class International extends Delivery {
    double customs;

    International(double w, double d, double customs) {
        super(w, d);
        this.customs = customs;
    }

    double calculate() {
        return 25 + 2 * weight + 0.50 * distance + customs;
    }

    String getType() {
        return "INTERNATIONAL";
    }
}

class DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            Delivery d;

            if (type.equals("STANDARD"))
                d = new Standard(weight, distance);
            else if (type.equals("EXPRESS"))
                d = new Express(weight, distance);
            else {
                double customs = sc.nextDouble();
                d = new International(weight, distance, customs);
            }

            double fee = d.calculate();
            System.out.printf("%s: %.2f%n", d.getType(), fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
