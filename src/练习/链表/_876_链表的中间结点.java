package 练习.链表;

/**
 * Created by lixin on 2020/8/3.
 *
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
class _876_链表的中间结点 {

    public static void main(String[] args) {
        //创建环形链表
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        System.out.println(ListNode.print(middleNode2(listNode1)));

    }

    /**
     * 快慢指针方法
     */
    public static ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 迭代方法
     */
    public static ListNode middleNode(ListNode head) {
        if (head == null) return null;
        int length = 0;

        //获取链表长度
        ListNode tempHead = head;
        while (tempHead != null){
            length++;
            tempHead = tempHead.next;
        }

        //根据中间位index获取对应的链表起点
        int index = 0;
        while (index < length / 2){
            index++ ;
            head = head.next;
        }
        return head;

    }

}
