
import java.util.*;
import java.time.*;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getDays());
    }
}

class Basic extends Plan {
    Basic(String name, LocalDate date) {
        super(name, date);
    }

    int getDays() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(String name, LocalDate date) {
        super(name, date);
    }

    int getDays() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String name, LocalDate date) {
        super(name, date);
    }

    int getDays() {
        return 365;
    }
}

class PlanRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            Plan p;

            if (type.equals("BASIC"))
                p = new Basic(name, date);
            else if (type.equals("STANDARD"))
                p = new Standard(name, date);
            else
                p = new Premium(name, date);

            System.out.println(p.name + ": " + p.getRenewalDate());
        }
    }
}
