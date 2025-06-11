package 练习.二叉树.普通;

import java.util.ArrayList;
import java.util.List;

import 练习.二叉树.TreeNode;

/**
 * 日期 : 2020/9/19.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * 遍历方式 左-根-右
 */
class _94_二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> saveValue = new ArrayList<>();
        inorderTraversalRecursive(root , saveValue);
        return saveValue;
    }

    public void inorderTraversalRecursive(TreeNode parent , List<Integer> list) {
        if (parent == null) return;
        inorderTraversalRecursive(parent.left , list);
        list.add(parent.val);
        inorderTraversalRecursive(parent.right , list);
    }

}
