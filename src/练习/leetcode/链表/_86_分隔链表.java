package 练习.leetcode.链表;

import 练习.leetcode.ListNode;

/**
 * 日期 : 2021/12/17.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/partition-list/
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 */
class _86_分隔链表 {

    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0);
        ListNode leftTail = leftHead;

        ListNode rightHead = new ListNode(0);
        ListNode rightTail = rightHead;

        while (head != null){
            if (head.val < x){
                leftTail.next = head;
                leftTail = head;
            } else {
                rightTail.next = head;
                rightTail = head;
            }
            head = head.next;
        }
        rightTail.next = null;
        leftTail.next = rightHead.next;
        return leftHead.next;
    }
}
