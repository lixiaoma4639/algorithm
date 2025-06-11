package 练习.leetcode.栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * 日期 : 2021/12/26.
 * 创建 : xin.li
 * 描述 :
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 */
class _739_每日温度 {
    public static void main(String[] args) {
        int[] height = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(height)));
    }

    /**
     * 使用动态规划倒推 解决
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] height = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true){
                if (temperatures[i] < temperatures[j]){
                    height[i] = j - i;
                    break;
                } else if (height[j] == 0){
                    height[i] = 0;
                    break;
                }
                j = height[j] + j;
            }
        }

        return height;
    }

    /**
     * 使用栈解决
     */
    public static int[] dailyTemperatures2(int[] temperatures) {
        int[] height = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                Integer pop = stack.pop();
                height[pop] = i - pop;
            }
            stack.push(i);
        }

        return height;
    }
}
