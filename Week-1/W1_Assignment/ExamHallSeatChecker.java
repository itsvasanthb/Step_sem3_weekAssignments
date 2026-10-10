
import java.util.Scanner;

class ExamHallSeatChecker {
    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    boolean alreadyPrinted = false;

                    for (int k = 0; k < i; k++) {
                        if (seatNumbers[k] == seatNumbers[i])
                            alreadyPrinted = true;
                    }

                    if (!alreadyPrinted) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                        found = true;
                    }
                }
            }
        }

        if (!found)
            System.out.println("No Duplicate Seats Found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] seats = new int[5];

        System.out.println("Enter 5 seat numbers:");
        for (int i = 0; i < 5; i++)
            seats[i] = sc.nextInt();

        checkDuplicateSeats(seats);
    }
}
