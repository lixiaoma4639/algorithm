package 练习.链表;

/**
 * Created by lixin on 2020/7/26.
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
class _203_移除链表元素 {

    public static void main(String[] args) {
        //创建环形链表
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        ListNode newListNode = removeElements2(listNode1, 3);
        System.out.println(ListNode.print(newListNode));
    }

    public static ListNode removeElements2(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode previousNode = newHead ;

        while (head != null){
            if (head.val == val){
                previousNode.next = head.next;
            } else {
                previousNode = head;
            }
            head = head.next;
        }
        return newHead.next;
    }


    public static ListNode removeElements(ListNode head, int val) {
        if (head == null || head.next == null) return head;
        // 创建上一位节点
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        //初始化临时的上一位节点 和 临时当前节点
        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                //当前的节点指向 当前的下一位节点
                prev.next = curr.next;
            } else {
                //当前节点赋值给上一位节点
                prev = curr;
            }
            //当前节点加1
            curr = curr.next;
        }
        //返回
        return sentinel.next;
    }
}
