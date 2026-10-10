
import java.util.*;

abstract class Vehicle {
    int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculate();
    abstract String getType();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    double calculate() {
        return hours * 10;
    }

    String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    double calculate() {
        return 30 + (hours - 1) * 20;
    }

    String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    double calculate() {
        return Math.max(100, hours * 50);
    }

    String getType() {
        return "TRUCK";
    }
}

class ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle v;

            if (type.equals("BIKE"))
                v = new Bike(hours);
            else if (type.equals("CAR"))
                v = new Car(hours);
            else
                v = new Truck(hours);

            double charge = v.calculate();
            System.out.printf("%s: %.2f%n", v.getType(), charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
