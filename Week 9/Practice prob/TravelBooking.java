
import java.util.*;

abstract class Travel {
    double distance;
    static final double BOOKING_FEE = 50;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
    abstract String getMode();

    double getTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends Travel {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }

    String getMode() {
        return "BUS";
    }
}

class Train extends Travel {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }

    String getMode() {
        return "TRAIN";
    }
}

class Flight extends Travel {
    Flight(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + distance * 4;
    }

    String getMode() {
        return "FLIGHT";
    }
}

class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Travel t;

            if (mode.equals("BUS"))
                t = new Bus(distance);
            else if (mode.equals("TRAIN"))
                t = new Train(distance);
            else
                t = new Flight(distance);

            System.out.printf("%s: %.2f%n", t.getMode(), t.getTotal());
        }
    }
}
