package 练习.二叉树.普通;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 日期 : 2020/10/19.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 */
class _114_二叉树展开为链表 {

    /**
     * 解法一
     */
    public void flatten3(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode left = poll.left;
            TreeNode right = poll.right;

            if (left != null) {
                queue.offer(left);
                poll.left = null;
                poll.right = left;
            }
            if (right != null) {
                queue.offer(right);
            }

        }
    }


    /**
     * 解法一优化
     *      1
     *     / \
     *    2   5
     *   / \   \
     *  3   4   6
     */
    private TreeNode newNode;
    public void flatten(TreeNode root) {
        if (root == null) return;
        newNode = root;
        preTraverse(newNode);
    }
    private void preTraverse(TreeNode node){
        if (node == null) return;
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (node != newNode){
            newNode.left = null;
            newNode.right = node;
            newNode = newNode.right;
        }
        preTraverse(left);
        preTraverse(right);
    }


    /**
     * 解法一 , 时间复杂度 O(2n)
     */
    public void flatten2(TreeNode root) {
        if (root == null) return;
        List<TreeNode> linkedList = new LinkedList<>();
        preTraverse2(linkedList , root);
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = linkedList.get(i);
            node.left = null;
            if (i < size-1){
                node.right = linkedList.get(i + 1);
            }
        }
    }
    private void preTraverse2(List<TreeNode> list , TreeNode node){
        if (node == null) return;
        list.add(node);
        preTraverse2(list , node.left);
        preTraverse2(list , node.right);
    }


    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }

    /**
     * 官方迭代解法
     */
    class Solution {
        public void flatten(TreeNode root) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    list.add(node);
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                node = node.right;
            }
            int size = list.size();
            for (int i = 1; i < size; i++) {
                TreeNode prev = list.get(i - 1), curr = list.get(i);
                prev.left = null;
                prev.right = curr;
            }
        }
    }

}
