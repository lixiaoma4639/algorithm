package 练习.栈;

import java.util.Stack;

/**
 * 日期 : 2020/8/20.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/basic-calculator/
 *
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 *
 * 示例 1:
 *
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 *
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 *
 * 输入: "(1+(4+5+2)-3)-(1-2)"
 * 输出:
 * stack1: -2 1 -3 2 5 4 1
 * stack2:  + - +  + + +
 *  1 + 4 + 5 + 2 + (-3) - 1 + (-2) = 6
 *
 *
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
class _224_基本计算器 {
    public static void main(String[] args) {
        String a = "(1+(4+5+20)-3)+(6+8)";
//        a = " 2-1 + 2 ";
        a = "+-)(";
//        a = "(1+(4+5+2)-3)-(1-2)";
//        a = "(1+(4+5+2)-3)+(6+8)";
        a = "(3-(2-(5-(9-(4)))))";
        //
        System.out.println("calculate(a) = " + calculate2(a));
    }

    public static int calculate2(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0; // For the on-going result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {
            // "(1+(4+5+2)-3)-(1-2)"
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = 10 * operand + (int) (ch - '0');
            } else if (ch == '+') {
                result += sign * operand;
                sign = 1;
                operand = 0;
            } else if (ch == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (ch == ')') {
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return result + (sign * operand);
    }


    public static int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        operations.push('+');
        boolean isNeedChange = false , isOperation = true;
        int total = 0;
        int flag = 1; // 1代表正数  , -1代表负数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //(3-(2-(5-(9-(4)))))
            switch (c){
                case ' ':
                    break;
                case '(':
                    isNeedChange = flag == -1;
                    break;
                case ')':
                    isNeedChange = false;
                    break;
                case '+':
                    flag = 1;
                    operations.push(isNeedChange ? '-' : '+');
                    isOperation = true;
                    break;
                case '-':
                    flag = -1;
                    operations.push(isNeedChange ? '+' : '-');
                    isOperation = true;
                    break;
                default:
                    if (isOperation){
                        numbers.push(Integer.parseInt(String.valueOf(c)));
                        isOperation = false;
                    } else {
                        Integer top = numbers.pop();
                        String newStr = top + String.valueOf(c);
                        numbers.push(Integer.parseInt(newStr));
                    }
                    break;
            }
        }
        if (numbers.isEmpty()) return 0;
        //* stack1: 1 4 5 2 3 6 8
        //* stack2: + + + + - + +
        //* 后缀表示法 0 + 8 + 6 - 3 + 2 + 5 + 4 + 1
        while (!numbers.isEmpty()){
            Integer topNum = numbers.pop();
            Character popOpera = operations.pop();
            if (popOpera == '+'){
                total = total + topNum;
            } else {
                total = total - topNum;
            }
        }
        return total;
    }
}
