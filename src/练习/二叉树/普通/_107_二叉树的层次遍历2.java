package 练习.二叉树.普通;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 练习.二叉树.TreeNode;

/**
 * 日期 : 2020/10/13.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 */
class _107_二叉树的层次遍历2 {

    public static void main(String[] args) {
        _107_二叉树的层次遍历2 levelOrder = new _107_二叉树的层次遍历2();
        TreeNode root  = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        List<List<Integer>> lists = levelOrder.levelOrderBottom(root);
        System.out.println("lists = " + lists);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> parentList = new LinkedList<>();
        if (root == null) return parentList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> childList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                childList.add(poll.val);

                TreeNode left = poll.left;
                TreeNode right = poll.right;
                if (left != null) queue.offer(left);
                if (right != null) queue.offer(right);
            }
            parentList.add(0 , childList);
        }
        return parentList;
    }






}












