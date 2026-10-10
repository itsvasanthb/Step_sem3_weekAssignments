
import java.util.Scanner;

class InventoryBalancer {
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        int max = sectionA[0];
        String section = "Section A";
        int item = 1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > max) {
                max = sectionA[i];
                section = "Section A";
                item = i + 1;
            }

            if (sectionB[i] > max) {
                max = sectionB[i];
                section = "Section B";
                item = i + 1;
            }
        }

        String status = totalA == totalB ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA +
                " | Section B Total: " + totalB +
                " | Status: " + status +
                " | Highest Quantity: " + max +
                " (" + section + ", Item " + item + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sectionA = new int[3];
        int[] sectionB = new int[3];

        System.out.println("Enter 3 quantities for Section A:");
        for (int i = 0; i < 3; i++)
            sectionA[i] = sc.nextInt();

        System.out.println("Enter 3 quantities for Section B:");
        for (int i = 0; i < 3; i++)
            sectionB[i] = sc.nextInt();

        analyzeInventory(sectionA, sectionB);
    }
}
