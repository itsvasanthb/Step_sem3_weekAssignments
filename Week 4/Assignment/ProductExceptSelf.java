
import java.util.*;

class ProductExceptSelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int product = 1;

        for (int i = 0; i < n; i++) {
            ans[i] = product;
            product *= nums[i];
        }

        product = 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= product;
            product *= nums[i];
        }

        System.out.println(Arrays.toString(ans));
    }
}
