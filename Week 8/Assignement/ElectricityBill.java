
import java.util.*;

abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculate();
    abstract String getType();
}

class Single extends Room {
    Single(int units) {
        super(units);
    }

    double calculate() {
        return units * 8;
    }

    String getType() {
        return "SINGLE";
    }
}

class Shared extends Room {
    int occupants;

    Shared(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculate() {
        return units * 6.0 / occupants;
    }

    String getType() {
        return "SHARED";
    }
}

class AC extends Room {
    AC(int units) {
        super(units);
    }

    double calculate() {
        return units * 10 + 200;
    }

    String getType() {
        return "AC";
    }
}

class ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room r;

            if (type.equals("SINGLE"))
                r = new Single(units);
            else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                r = new Shared(units, occupants);
            } else
                r = new AC(units);

            double bill = r.calculate();
            System.out.printf("%s: %.2f%n", r.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
