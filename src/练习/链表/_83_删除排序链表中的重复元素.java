package 练习.链表;

/**
 * Created by lixin on 2020/7/28.
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
class _83_删除排序链表中的重复元素 {

    public static void main(String[] args) {
        //创建环形链表
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(4);
        ListNode listNode8 = new ListNode(8);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        System.out.println(ListNode.print(deleteDuplicates(listNode1)));
    }


    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
