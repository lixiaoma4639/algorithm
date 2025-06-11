package 练习.二叉树.普通;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import 练习.二叉树.TreeNode;


/**
 * 日期 : 2020/9/19.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 *
 * 遍历方式 根-左-右
 */
class _144_二叉树的前序遍历 {

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> saveValue = new ArrayList<>();
        preorderTraversalRecursive(root , saveValue);
        return saveValue;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> saveValue = new ArrayList<>();
        preorderTraversalRecursive(root , saveValue);
        return saveValue;
    }

    private void preorderTraversalRecursive(TreeNode parent , List<Integer> list){
        if (parent == null) return;
        list.add(parent.val);
        preorderTraversalRecursive(parent.left , list);
        preorderTraversalRecursive(parent.right , list);
    }


    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            TreeNode root  = new TreeNode(3);
            root.left = new TreeNode(1);
            root.right = new TreeNode(4);
            solution.preorderTraversal(root);
        }


        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<Integer> output = new LinkedList<>();

            /*
            *               1
            *           2       4
            *       0      3         5
            *                1
            *
            * */
            TreeNode node = root;
            while (node != null) {
                if (node.left == null) {
                    output.add(node.val);
                    node = node.right;
                } else {
                    TreeNode predecessor = node.left;
                    while ((predecessor.right != null) && (predecessor.right != node)) {
                        predecessor = predecessor.right;
                    }

                    if (predecessor.right == null) {
                        output.add(node.val);
                        predecessor.right = node;
                        node = node.left;
                    } else{
                        predecessor.right = null;
                        node = node.right;
                    }
                }
            }
            return output;
        }
    }
}
