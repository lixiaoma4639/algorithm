package 练习.leetcode.树;

import 练习.leetcode.TreeNode;

/**
 * 日期 : 2022/1/29.
 * 创建 : xin.li
 * 描述 :
 *
 *      3
 *   5      1
 * 6   2   0  8
 *    7  4
 */
class _236_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findPublicParent(root, p, q);
    }

    /**
     * null null
     * null q
     * p null
     * p q
     */
    private TreeNode findPublicParent(TreeNode root, TreeNode p, TreeNode q){// 7 2
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = findPublicParent(root.left, p, q);// null null
        TreeNode right = findPublicParent(root.right, p, q);//null 4
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
