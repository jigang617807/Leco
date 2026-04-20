import java.util.Scanner;

public class GetWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 第一行：输入测试样例的个数
        int numCases = sc.nextInt();

        // 循环处理每一个样例
        for (int i = 0; i < numCases; i++) {
            // 这里我们假设每一行数据的格式是：先输入数组长度 n，再输入 n 个整数
            // 如果你的输入格式直接是一整行数字，需要根据实际情况调整
            int n = sc.nextInt();
            int[] height = new int[n];
            for (int j = 0; j < n; j++) {
                height[j] = sc.nextInt();
            }

            // 调用接雨水逻辑并输出结果
            System.out.println(trap(height));
        }
        sc.close();
    }

    /**
     * 接雨水核心算法（双指针法）
     */
    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int maxWater = 0;

        while (left < right) {
            // 更新当前左右两边的最大高度
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // 核心逻辑：木桶效应，水的高度取决于较低的那一侧
            if (leftMax < rightMax) {
                // 左边较低，计算左侧积水并右移
                maxWater += leftMax - height[left];
                left++;
            } else {
                // 右边较低（或相等），计算右侧积水并左移
                maxWater += rightMax - height[right];
                right--;
            }
        }
        return maxWater;
    }
}