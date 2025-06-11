package 练习.链表;

/**
 * Created by lixin on 2020/7/26.
 *
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
class _237_删除链表中的节点 {

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

        deleteNode2(listNode2);
        System.out.println(ListNode.print(listNode1));
    }

    public static void deleteNode2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
