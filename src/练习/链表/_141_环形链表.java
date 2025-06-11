package 练习.链表;

/**
 * Created by lixin on 2020/7/26.
 * 判断链表是否有环
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
class _141_环形链表 {

    public static void main(String[] args) {
        //创建环形链表
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode2;


        System.out.println(hasCycle(listNode1));

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        //慢指针
        ListNode slow = head;
        //快指针
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            //如果快慢指针相等,说明有环
            if (slow == fast) return true;
            //慢指针一次跑一步
            slow = slow.next;
            //快指针一次跑两步
            fast = fast.next.next;
        }
        return false;
    }
}
