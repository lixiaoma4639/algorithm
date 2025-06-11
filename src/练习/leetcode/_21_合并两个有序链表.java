package 练习.leetcode;



/**
 * 日期 : 2021/5/25.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 */
class _21_合并两个有序链表 {
    public static void main(String[] args) {
        ListNode aListNode1 = new ListNode(1);
        ListNode aListNode2 = new ListNode(2);
        ListNode aListNode4 = new ListNode(6);
        aListNode1.next = aListNode2;
        aListNode2.next = aListNode4;

        ListNode bListNode1 = new ListNode(1);
        ListNode bListNode3 = new ListNode(3);
        ListNode bListNode4 = new ListNode(4);
        ListNode bListNode5 = new ListNode(5);
        bListNode1.next = bListNode3;
        bListNode3.next = bListNode4;
        bListNode4.next = bListNode5;
        ListNode listNode = mergeTwoLists(aListNode1, bListNode1);
        while (listNode != null){
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }

    }

    /**
     * 输入：l1 = [1,2,4], l2 = [1,3,4,5]
     *
     * 输出：[1,1,2,3,4,4]
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next , l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1 , l2.next);
            return l2;
        }
    }


    /**
     * 输入：l1 = [1,2,4], l2 = [1,3,4,5]
     *
     * 输出：[1,1,2,3,4,4]
     */
    public static ListNode mergeTwoLists4(ListNode l1, ListNode l2) {
        ListNode prevNode = new ListNode(-1);
        ListNode headNode = prevNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val){
                headNode.next = l1;
                l1 = l1.next;
                headNode = headNode.next;
            } else {
                headNode.next = l2;
                l2 = l2.next;
                headNode = headNode.next;
            }
        }
        headNode.next = l1 == null ? l2 : l1;
        return prevNode.next;
    }













    /**
     * 输入：l1 = [1,2,4], l2 = [1,3,4,5]
     *
     * 输出：[1,1,2,3,4,4]
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prevNode = new ListNode(-1);

        ListNode headNode = prevNode;
        while (l1 != null && l2 != null ) {
            if (l1.val <= l2.val){
                headNode.next = l1;
                l1 = l1.next;
                headNode = headNode.next;
            } else {
                headNode.next = l2;
                l2 = l2.next;
                headNode = headNode.next;
            }
        }

        headNode.next = (l1 == null ? l2 : l1);

        return prevNode.next;
    }

}
