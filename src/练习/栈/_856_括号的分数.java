package 练习.栈;

import java.util.Stack;

/**
 * Created by lixin on 2020/8/14.
 *
 * https://leetcode-cn.com/problems/score-of-parentheses/
 *
 * "(((())))"
 *
 *  1 * 2
 *  1 * 2 * 2
 *
 *  8 + 4 + 2 + 1
 *
 */
class _856_括号的分数 {

    public static void main(String[] args) {

        String s = "(()((()())()))";

        System.out.println(scoreOfParentheses(s));
        System.out.println(scoreOfParentheses3(s));
    }


    public static int scoreOfParentheses3(String S) {
        int ans = 0, deep = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                deep++;
            } else {
                deep--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << deep;
            }
        }

        return ans;
    }

    /**
     * (()((A A)()))
     *
     * 0
     * 0 1 = 2
     * 0 0 0 2 = 16
     * 0 0 1 = 4
     * 0 0
     * 0
     * = 22
     */
    public static int scoreOfParentheses2(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int top = stack.pop(); // 0
                int lastSecond = stack.pop();// 0
                stack.push(lastSecond + Math.max(2 * top, 1));
            }
        }

        return stack.pop();
    }

    /**
     * 自己实现
     */
    public static int scoreOfParentheses(String S) {
        //是否是(符号
        boolean isStart = false;
        int deep = 0 , total = 0;
        for (char cr : S.toCharArray()) {
            if (cr == '('){
                isStart = true;
                deep++;
            } else {
                deep--;
                if (isStart){
                    isStart = false;
                    // total += (1 * 2的deep次幂)
//                    total += (1 << deep);
                    total += (1 * Math.pow(2 , deep));
                }
            }
        }

        return total;
    }
    /**
     * 自己实现2
     * (()((A A)()))
     * 010011
     *
     *  0
     *  0 1 = 2
     *  0 0 0 2 = 16
     *  0 0 1 = 4
     *  0 0
     *  0
     * = 22
     */
    public static int scoreOfParentheses4(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char cr : S.toCharArray()) {
            if ('(' == cr){
                stack.push(0);
            } else {
                int last = stack.pop();
                int secondLast = stack.pop();
                stack.push(secondLast + last * 2);
            }
        }

        return stack.pop();
    }
}
