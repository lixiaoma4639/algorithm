package 练习.二叉树.二叉搜索树;

import java.util.LinkedList;
import java.util.Queue;

import 练习.二叉树.TreeNode;

/**
 * 日期 : 2020/8/30.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/invert-binary-tree/
 */
class _226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;

            TreeNode left = poll.left;
            TreeNode right = poll.right;
            if (left != null) queue.add(left);
            if (right != null) queue.add(right);
        }
        return root;
    }
}
