package 练习.leetcode.链表;

import 练习.leetcode.ListNode;

/**
 * 日期 : 2021/12/5.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
class _203_移除链表元素 {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode startNode = null;
        ListNode endNode = null;
        while (head != null){
            if (head.val == val){
                //跳过
            } else {
                if (startNode == null){
                    startNode = head;
                    endNode = head;
                } else {
                    //将startNode的末尾节点的next指向新的节点
                    endNode.next = head;
                    //记录新的末尾节点
                    endNode = head;
                }
            }
            head = head.next;
        }
        if (endNode == null){
            return null;
        }
        endNode.next = null;
        return startNode;
    }

    /**
     * 使用虚拟头节点简化代码
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode startNode = new ListNode(0);
        ListNode endNode = startNode;
        while (head != null){
            if (head.val != val){
                endNode.next = head;
                endNode = head;
            }
            head = head.next;
        }
        endNode.next = null;
        return startNode.next;
    }
}
