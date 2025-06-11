package 练习.链表;


/**
 * Created by lixin on 2020/7/26.
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
class _206_反转链表 {

    public static void main(String[] args) {
        //创建链表
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(ListNode.print(listNode1));
        //打印正常链表
//        ListNode head = listNode1;
        //反转链表并打印
//        ListNode head = reverseList(listNode1);
//        ListNode head = reverseList2(listNode1);
        ListNode newHead = reverseList(listNode1);
        System.out.println(ListNode.print(newHead));
    }

    public static ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newNode = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;
        }
        return newNode;
    }

    /**
     * 迭代反转
     */
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newNode = null;
        do {
            ListNode temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;
        } while (head != null);
        return newNode;
    }








    /**
     * 使用迭代反转列表
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null){
            //将head的下一个节点临时存起来
            ListNode temp = head.next;
            //将新的head赋值给身后的节点.next
            head.next = newHead;
            //生成新head
            newHead = head;
            //生成新一次迭代的head
            head = temp;
        }
        return newHead;
    }

    /**
     * 使用递归 反转链表
     * @param head 链表
     * @return
     * 0 -> 1 -> 2 -> 3 -> 4
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        //
        ListNode lastNode = reverseList(head.next);
        //lastNode = 4， head = 3,
        //lastNode = 3， head = 2,
        //lastNode = 2， head = 1,
        //lastNode = 1， head = 0,
        head.next.next = head;
        head.next = null;
        return lastNode;
    }

}
