package 练习.二叉树.普通;

import java.util.HashMap;
import java.util.Map;

/**
 * 日期 : 2020/10/19.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
class _106_从中序与后序遍历序列构造二叉树 {

    private int[] mPostOrder;
    private Map<Integer , Integer> inMap = new HashMap<>();
    private int position;

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        this.mPostOrder = postorder;
        for (int index = 0; index < inorder.length; index++) {
            inMap.put(inorder[index] , index);
        }
        position = inorder.length - 1;
        return doWith(0 , position);
    }

    /**
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    private TreeNode doWith(int inStart , int inEnd){
        if (inStart > inEnd) return null;
        int rootValue = mPostOrder[position];
        TreeNode root = new TreeNode(rootValue);
        position--;
        int inPosition = inMap.get(rootValue);
        //inPosition + 1 , inEnd 判断有没有右节点
        root.right = doWith(inPosition + 1 , inEnd);
        root.left = doWith(inStart , inPosition - 1);
        return root;
    }


    /* *//* 中序遍历 inorder =   [9,3,16,15,20,7,30]
      * 后序遍历 postorder = [9,16,15,30,7,20,3]
      * 返回如下的二叉树：
      *
      *     3
      *    / \
      *   9  20
      *     /  \
      *    15   7
      *   /      \
      * 16        30
      *//*
    private int[] mInorder, mPostOrder;
    private Map<Integer , Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        this.mInorder = inorder ;
        this.mPostOrder = postorder;
        for (int index = 0; index < inorder.length; index++) {
            inorderMap.put(inorder[index] , index);
        }
        int index = inorder.length - 1;
        TreeNode root = post(postorder[index] , index);
        return root;
    }
    *//**
     * @param previous 值 :3 3
     * @param postEnd 角标:6 5
     *//*
    private TreeNode post(int previous , int postEnd){
        if (postEnd < 0) return null;
        int value = mPostOrder[postEnd];// 值: 3 20
        if (inorderMap.get(value) < inorderMap.get(previous)) return null;
        TreeNode root = new TreeNode(value);// 3 20
        root.left = in(value , inorderMap.get(value) - 1);//9 15
        root.right = post(value, postEnd - 1); // 20
        return root;
    }
    *//* 中序遍历 inorder =   [9,3,16,15,20,7,30]   左中右
     * 后序遍历 postorder = [9,16,15,30,7,20,3]   左右中
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *   /      \
     * 16        30
     *
     *//*
    private TreeNode in(int previous , int inorderEnd){
        if (inorderEnd < 0) return null;
        int value = mInorder[inorderEnd];//15 16
        if (postMap.get(value) > postMap.get(previous)) return null;
        TreeNode root = new TreeNode(value);//9 15
        root.left = in(value , inorderEnd - 1);
        root.right = post(value , postMap.get(value) - 1);
        return root;
    }




    static class Solution2{
        private int[] mPostOrder;
        private Map<Integer , Integer> inMap = new HashMap<>();
        private int mIndex;

        public TreeNode buildTree2(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null) return null;
            this.mPostOrder = postorder;
            for (int index = 0; index < inorder.length; index++) {
                inMap.put(inorder[index] , index);
            }
            mIndex = inorder.length - 1;
            TreeNode root = post(mIndex -1 , mIndex);
            return root;
        }
        *//*
         * c + 1 =
         *
         * 返回如下的二叉树：
         *
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         *   /      \
         * 16        30
         *                 最左边                  最右边
         * 中序遍历 inorder =   [9, 3,16,15,20,7, 30]   左中右
         * 后序遍历 postorder = [9,16,15,30,7 ,20, 3]   左右中
         *//*
        private TreeNode doWith(int postPrevious , int postCurrent , int inPrevious , int inCurrent ){
            // 4 , 6
            if (inPrevious < inCurrent ) return null;

            int pcValue = mPostOrder[mIndex]; // 值: 3 20 7 30
            mIndex--;
            TreeNode root = new TreeNode(pcValue);
            root.right = doWith(0 , 0 ,   inMap.get(mPostOrder[mIndex]) , inMap.get(pcValue));
            root.left = doWith()


            return root;
        }
        *//*
         * c + 1 =
         *
         * 返回如下的二叉树：
         *
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         *   /      \
         * 16        30
         *                 最左边                  最右边
         * 中序遍历 inorder =   [9, 3,16,15,20,7, 30]   左中右
         * 后序遍历 postorder = [9,16,15,30,7 ,20, 3]   左右中
         *
         *//*
        private TreeNode post(int postPrevious , int postCurrent , int inPrevious , int inCurrent){
            if (inPrevious > inCurrent ) return null;
            int pcValue = mPostOrder[postCurrent]; // 值: 3 20 7 30          //左值 3
            int ppValue = mPostOrder[postPrevious];// 值: 20 7 30 15         //左值
            int ipIndex = inMap.get(pcValue);//角标: 1 4 5 6                  //左角标
            int icIndex = inMap.get(ppValue);//角标: 4 5 6 3                  //左角标
            TreeNode root = new TreeNode(pcValue);//
            root.right = post(postPrevious -1  , postPrevious , ipIndex , icIndex); //
            root.left = in(inMap.get(mInOrder[ipIndex - 1]) , pcValue , ipIndex - 2 , ipIndex - 1);//
            return root;
        }
        private TreeNode in(int postPrevious , int postCurrent , int inPrevious , int inCurrent){
            if (postPrevious > postCurrent) return null;
            int icValue = mInOrder[inCurrent];
            int ipValue = mInOrder[inPrevious];
            TreeNode root = new TreeNode(icValue);//
            root.right = post(postPrevious -1  , postPrevious , ipIndex , icIndex); //
            root.left = in(inMap.get(mInOrder[ipIndex - 1]) , pcValue , ipIndex - 2 , ipIndex - 1);//
            return root;
        }
    }


    static class Solution {

        HashMap<Integer,Integer> memo = new HashMap<>();
        int[] post;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for(int i = 0;i < inorder.length; i++) {
                memo.put(inorder[i], i);
            }
            post = postorder;
            TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
            return root;
        }

        public TreeNode buildTree(int is, int ie, int ps, int pe) {// 2 6 1 5
            if(ie < is || pe < ps) return null;

            int root = post[pe]; //     3 9 20
            int ri = memo.get(root);//  1 0 4

            *//**
             * 中序遍历 inorder =   [9, 3,16,15,20,7, 30]   左中右
             * 后序遍历 postorder = [9,16,15,30,7 ,20, 3]   左右中
             *//*
            TreeNode node = new TreeNode(root);
            node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
            node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
            return node;
        }
   } }*/


    /*
     * c + 1 =
     *
     * 返回如下的二叉树：
     *
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     */


    public static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    static class Solution5 {
        int post_idx;
        int[] postorder;
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        /*
         * c + 1 =
         *
         * 返回如下的二叉树：
         *
         * 返回如下的二叉树：
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         * 中序遍历 inorder = [9,3,15,20,7]
         * 后序遍历 postorder = [9,15,7,20,3]
         */
        public TreeNode helper(int in_left, int in_right) {
            // 如果这里没有节点构造二叉树了，就结束
            if (in_left > in_right) {
                return null;
            }
            // 选择 post_idx 位置的元素作为当前子树根节点
            int root_val = postorder[post_idx];
            TreeNode root = new TreeNode(root_val);
            // 根据 root 所在位置分成左右两棵子树
            int index = inMap.get(root_val);
            // 下标减一
            post_idx--;
            // 构造右子树
            root.right = helper(index + 1, in_right); // 5 4
            // 构造左子树
            root.left = helper(in_left, index - 1); // 4 , 3
            return root;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postorder = postorder;
            // 从后序遍历的最后一个元素开始
            post_idx = postorder.length - 1;

            // 建立（元素，下标）键值对的哈希表
            int idx = 0;
            for (Integer val : inorder) {
                inMap.put(val, idx++);
            }

            return helper(0, inorder.length - 1);
        }
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] a = {9,3,15,20,7};
        int[] b = {9,15,7,20,3};
        solution5.buildTree(a , b);
    }
}
