package 练习.二叉树.普通;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 练习.二叉树.TreeNode;

/**
 * 日期 : 2020/9/19.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
class _102_二叉树的层序遍历 {

    public static void main(String[] args) {
        _102_二叉树的层序遍历 levelOrder = new _102_二叉树的层序遍历();
        TreeNode root  = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        levelOrder.levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                level.add(poll.val);

                TreeNode left = poll.left;
                TreeNode right = poll.right;
                if (left != null) queue.offer(left);
                if (right != null) queue.offer(right);
            }
            lists.add(level);
        }
        return lists;
    }
}
