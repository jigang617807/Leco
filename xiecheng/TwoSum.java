package xiecheng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int target = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int[] ans = twoSum(nums, target);
            if (ans[0] == -1) {
                System.out.println("-1 -1");
            } else {
                System.out.println(ans[0] + " " + ans[1]);
            }
        }

        sc.close();
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (indexMap.containsKey(need)) {
                return new int[] { indexMap.get(need), i };
            }
            indexMap.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}
