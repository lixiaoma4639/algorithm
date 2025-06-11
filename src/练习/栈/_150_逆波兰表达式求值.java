package 练习.栈;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 日期 : 2020/8/19.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 *
 * 逆波兰表示法(后缀表示法):
 *
 * 前缀表示法 （+ 3 4 ）
 * 中缀表示法 （3 + 4）
 * 后缀表示法 （3 4 + ）
 *
 * 规则:
 * 表达“三加四”时，写作“3 4 + ”，而不是“3 + 4”
 * 多个操作符，操作符置于第二个操作数的后面，
 * 所以常规中缀记法的“3 - 4 + 5”在逆波兰记法中写作“3 4 - 5 + ”
 *
 * 例如:
 * 3 - 4 * 5    5是第二个操作数, 逆波兰表示:  3 4 5 * -
 *（3 - 4）*5    4是第二个操作数, 逆波兰表示:  3 4 - 5 *
 * 5 + ((1 + 2) * 4) - 3       逆波兰表示:  5 1 2 + 4 * + 3 -
 *
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *    (9 + 3) * (-11)
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
class _150_逆波兰表达式求值 {

    public static void main(String[] args) {
        //输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//        int a = (9 + 3) * (-11);
//        int b = 10 * (6 / a) + 17 + 5;
//        System.out.println("b = " + b);
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        //"(1+(4+5+2)-3)+(6+8)"
        String[] tokens2 = {"1", "4", "5", "+", "2", "+", "+", "3", "-", "6", "8", "+", "+"};
        System.out.println("tokens = " +  evalRPN(tokens2));
    }


    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int top, secondTop;
        for (String element: tokens) {
            switch (element){
                case "+":
                    top = stack.pop();
                    secondTop = stack.pop();
                    stack.push(secondTop + top);
                    break;
                case "-":
                    top = stack.pop();
                    secondTop = stack.pop();
                    stack.push(secondTop - top);
                    break;
                case "*":
                    top = stack.pop();
                    secondTop = stack.pop();
                    stack.push(secondTop * top);
                    break;
                case "/":
                    top = stack.pop();
                    secondTop = stack.pop();
                    stack.push(secondTop / top);
                    break;
                default:
                    stack.push(Integer.parseInt(element));
                    break;
            }
        }
        return stack.pop();
    }

}
