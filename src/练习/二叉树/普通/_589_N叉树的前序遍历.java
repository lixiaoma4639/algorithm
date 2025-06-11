package 练习.二叉树.普通;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * 日期 : 2020/10/15.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *              1
 *      3       2       4
 *  5       6
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 */
class _589_N叉树的前序遍历 {

    public List<Integer> preorder2(Node root) {
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }


    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        list.add(root.val);
        recursion(list , root.children);
        return list;
    }

    private void recursion(List<Integer> list , List<Node> childrenList){
        if (childrenList == null) return;
        for (Node node : childrenList) {
            list.add(node.val);
            recursion(list , node.children);
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
    };
}
