package 练习.二叉树.普通;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 日期 : 2020/10/15.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *              1
 *      3       2            4
 *  5       6          4.1      4.2
 *
 * [5,6,3,2,4,1].
 */
class _590_N叉树的后序遍历 {

    public List<Integer> postorder2(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            list.add(0, poll.val);
            for (Node childNode : poll.children) {
                queue.addFirst(childNode);
            }
        }

        return list;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        recursion(list , root.children);
        list.add(root.val);
        return list;
    }

    private void recursion(List<Integer> list , List<Node> childrenList){
        if (childrenList == null) return;
        for (Node node : childrenList) {
            recursion(list, node.children);
            list.add(node.val);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
