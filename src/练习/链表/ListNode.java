package 练习.链表;

/**
 * Created by lixin on 2020/7/26.
 */
class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    /**
     * 打印链表数据
     */
    static String print(ListNode head){
        String print = "[ ";
        while (head != null) {
            print += (head.val + ", ");
            head = head.next;
        }
        print += "]";
        return print;
    }
}
