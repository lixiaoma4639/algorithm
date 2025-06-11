package 练习.leetcode.链表;

import 练习.leetcode.ListNode;

/**
 * 日期 : 2021/12/5.
 * 创建 : xin.li
 * 描述 :
 */
class _160_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (currentA != currentB){
            currentA = currentA == null ? headB : currentA.next;
            currentB = currentB == null ? headA : currentB.next;
        }
        return currentA;
    }
}
