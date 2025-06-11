package 练习.leetcode.链表;

import 练习.leetcode.ListNode;

/**
 * 日期 : 2021/12/5.
 * 创建 : xin.li
 * 描述 :
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
class _2_两数相加 {

    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return null;
        if (l2 == null) return null;
        ListNode startList = new ListNode(0);
        ListNode endList = startList;

        int add = 0;
        while (l1 != null || l2 != null){
            int l1Val = 0;
            if (l1 != null){
                l1Val = l1.val;
                l1 = l1.next;
            }
            int l2Val = 0;
            if (l2 != null){
                l2Val = l2.val;
                l2 = l2.next;
            }
            int sum = l1Val + l2Val + add;
            add = sum / 10;
            //这一步相当于把startList.next指向了新的node
            endList.next = new ListNode(sum % 10);
            endList = endList.next;
        }
        if (add > 0){
            endList.next = new ListNode(add);
        }

        return startList.next;

    }
}
