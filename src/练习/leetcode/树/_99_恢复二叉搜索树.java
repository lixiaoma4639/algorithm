package 练习.leetcode.树;

import 哈希表.map.Person;
import 数据结构_树.二叉搜索树.SearchBinaryTree;
import 数据结构_树.二叉搜索树.printer.BinaryTrees;
import 数据结构_树.二叉搜索树重构.BST;
import 算法.查找.二分.BinarySearch;
import 练习.leetcode.TreeNode;

/**
 * 日期 : 2022/1/29.
 * 创建 : xin.li
 * 描述 :
 *
 *          63
 *   37         78
 * 26   42    77  79
 *    40  49
 *
 * 26 37 40 63 49 42 77 78 79
 */
class _99_恢复二叉搜索树 {
    private TreeNode firstError;
    private TreeNode lastError;
    private TreeNode oldNode;

    public static void main(String[] args) {
        TreeNode node42 = new TreeNode(42);
        node42.left = new TreeNode(40);
        node42.right = new TreeNode(49);

        TreeNode node37 = new TreeNode(37);
        node37.left = new TreeNode(26);
        node37.right = node42;

        TreeNode node78 = new TreeNode(78);
        node78.left = new TreeNode(77);
        node78.right = new TreeNode(79);

        TreeNode root = new TreeNode(63);
        root.left = node37;
        root.right = node78;

        inOrder(root);
        System.out.println();
        System.out.println("--------------");
        inOrder2(root);
    }

    /**
     *           63
     *    37         78
     *  26   42    77  79
     *     40  49
     */
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        TreeNode node = root;
        while (node != null){
            if (node.left != null){
                //找前继节点
                TreeNode pre = node.left;
                while (pre.right != null && pre.right != node){
                    pre = pre.right;
                }
                if (pre.right == null){
                    pre.right = node;
                    node = node.left;
                } else {
                    pre.right = null;
                    findErrorNode(node);
                    node = node.right;
                }
            } else {
                findErrorNode(node);
                node = node.right;
            }
        }
        int temp = lastError.val;
        lastError.val = firstError.val;
        firstError.val = temp;
    }

    private void findErrorNode(TreeNode node){
        if (oldNode != null && oldNode.val > node.val){
            lastError = node;
            if (firstError != null) return;
            firstError = oldNode;
        }
        oldNode = node;
    }

    /**
     *           63
     *    37         78
     *  26   42    77  79
     *     40  49
     */
    public static void inOrder2(TreeNode root) {
        if (root == null) return;
        TreeNode node = root;
        while (node != null){
            if (node.left != null){
                //找前继节点
                TreeNode pre = node.left;
                while (pre.right != null && pre.right != node){
                    pre = pre.right;
                }
                if (pre.right == null){
                    pre.right = node;
                    node = node.left;
                } else {
                    pre.right = null;
                    System.out.print(node.val + " ");
                    node = node.right;
                }
            } else {
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }


    private static void inOrder(TreeNode root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }


    /**
     * 解法一
     * @param root
     */
    public void recoverTree2(TreeNode root) {
        recover(root);
        int temp = lastError.val;
        lastError.val = firstError.val;
        firstError.val = temp;
    }
    private void recover(TreeNode root){
        if (root == null) return;
        recover(root.left);
        if (oldNode != null && oldNode.val > root.val){
            lastError = root;
            if (firstError != null) return;
            firstError = oldNode;
        }
        oldNode = root;
        recover(root.right);
    }
}
