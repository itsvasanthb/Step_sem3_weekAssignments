
import java.util.*;

class MaximumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
