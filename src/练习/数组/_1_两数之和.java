package 练习.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lixin on 2020/8/9.
 *
 * https://leetcode-cn.com/problems/two-sum/
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
class _1_两数之和 {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15 , 11};

        int[] ints = twoSum(numbers, 22);
        System.out.println("[" + ints[0] + " , " + ints[1] +"]");
    }

    private static int[] twoSum(int[] numbers, int target) {
        Map<Integer , Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            if (map.containsKey(key)){
                return new int[]{map.get(key) , i};
            }
            map.put(numbers[i] , i);
        }
        return new int[0];
    }

    private static int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int number1 = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (number1 + numbers[j] == target)
                    return new int[]{i , j};
            }
        }
        return new int[0];
    }

}
