package 练习.栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {
    public static void main(String[] args) {
        String aaa = "((()(())))";
        System.out.println(isValid2(aaa));
    }


    public static boolean isValid2(String s) {
        if (s.isEmpty()) return true;
        Map<Character , Character> map = new HashMap<>();
        map.put('(' , ')');
        map.put('{' , '}');
        map.put('[' , ']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char at = s.charAt(i);
            if (map.containsKey(at)){
                stack.push(at);
            } else {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (at != map.get(pop)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        Map<Character , Character> map = new HashMap<>();
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char at = s.charAt(i);
            if (at == '{' || at == '(' || at == '['){
                stack.push(at);
            } else {
                Character pop = stack.pop();
                if ('[' == pop && at != ']') return false;
                if ('{' == pop && at != '}') return false;
                if ('(' == pop && at != ')') return false;
            }
        }
        return stack.isEmpty();
    }
}
