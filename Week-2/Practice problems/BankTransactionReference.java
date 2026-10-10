
import java.util.Scanner;

class BankTransactionReference {
    static String normalizeReference(String raw) {
        String ref = raw.trim();

        if (ref.length() >= 3)
            ref = ref.substring(0, 3).toUpperCase() + ref.substring(3);

        return ref;
    }

    static String validateAndFormat(String reference) {
        String ref = normalizeReference(reference);

        if (ref.length() != 14)
            return "Invalid: wrong length";

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(ref.charAt(i)))
                return "Invalid: bank code must be 3 letters";
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(ref.charAt(i)))
                return "Invalid: body must contain only digits";
        }

        String date = ref.substring(3, 9);
        String sequence = ref.substring(9);

        StringBuilder result = new StringBuilder();
        result.append("[").append(ref.substring(0, 3)).append("] ");
        result.append("DATE: ").append(date.substring(0, 2)).append("/");
        result.append(date.substring(2, 4)).append("/");
        result.append(date.substring(4, 6)).append(" | SEQ: ");
        result.append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter transaction reference: ");
        String ref = sc.nextLine();
        System.out.println(validateAndFormat(ref));
    }
}
