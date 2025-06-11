package 练习.二叉树.普通;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 练习.二叉树.TreeNode;

/**
 * 日期 : 2020/9/20.
 * 创建 : xin.li
 * 描述 :
 */
class _104_二叉树的最大深度 {

    /**
     * 迭代
     *
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int deep = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                TreeNode left = poll.left;
                TreeNode right = poll.right;
                if (left != null) queue.offer(left);
                if (right != null) queue.offer(right);
            }
            deep++;
        }
        return deep;
    }

    /**
     * 使用递归
     */
    public int maxDepth2(TreeNode root) {
        if (root == null ){
            return 0;
        } else {
            int left = maxDepth2(root.left); //3
            int right = maxDepth2(root.right);//  3
            return Math.max(left , right) + 1;
        }
    }

}
