package 练习.二叉树.普通;

import java.util.ArrayList;
import java.util.List;

import 练习.二叉树.TreeNode;

/**
 * 日期 : 2020/9/19.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * 遍历方式 左-右-根
 */
class _145_二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> saveValue = new ArrayList<>();
        postorderTraversalRe(root , saveValue);
        return saveValue;
    }

    public void postorderTraversalRe(TreeNode parent , List<Integer> list) {
        if (parent == null) return;
        postorderTraversalRe(parent.left , list);
        postorderTraversalRe(parent.right , list);
        list.add(parent.val);
    }
}
