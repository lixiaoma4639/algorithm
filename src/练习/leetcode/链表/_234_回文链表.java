package 练习.leetcode.链表;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import 练习.leetcode.ListNode;

/**
 * 日期 : 2021/12/5.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * 输入：head = [1,2,2,1]
 * 输入：head = [1,2,3,2,1]
 * 输出：true
 */
public class _234_回文链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;

        //找到中间节点
        ListNode quick = head;
        ListNode slow = head;
        while (quick.next != null && quick.next.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }

        //1-2-2-4-null, 反转后4-2-2-1-null
        //反转后半部分节点
        slow = slow.next;
        ListNode reverse = null;
        while (slow != null){
            ListNode temp = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = temp;
        }

        //前后比对
        while (reverse != null){
            if (head.val != reverse.val){
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }

        return true;
    }
}
