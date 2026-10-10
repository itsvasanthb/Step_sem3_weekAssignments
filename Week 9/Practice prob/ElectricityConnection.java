
import java.util.*;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
    abstract String getType();
}

class Home extends Connection {
    Home(int units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100)
            return units * 5;
        return 100 * 5 + (units - 100) * 7;
    }

    String getType() {
        return "HOME";
    }
}

class Shop extends Connection {
    Shop(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8 + 100;
    }

    String getType() {
        return "SHOP";
    }
}

class Factory extends Connection {
    Factory(int units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6.0, 1000);
    }

    String getType() {
        return "FACTORY";
    }
}

class ElectricityConnection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Connection c;

            if (type.equals("HOME"))
                c = new Home(units);
            else if (type.equals("SHOP"))
                c = new Shop(units);
            else
                c = new Factory(units);

            double bill = c.calculateBill();
            System.out.printf("%s: %.2f%n", c.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
