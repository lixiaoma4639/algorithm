package 练习.二叉树.普通;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import 练习.二叉树.TreeNode;

/**
 * 日期 : 2020/10/13.
 * 创建 : xin.li
 * 描述 :
 *
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 *
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 *
 * 输入:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class _662_二叉树最大宽度 {

    public static void main(String[] args) {
        _662_二叉树最大宽度 levelOrder = new _662_二叉树最大宽度();
        TreeNode root  = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        int i = levelOrder.widthOfBinaryTree(root);
        System.out.println("i = " + i);


    }

    /*
     *         1
     *        / \
     *       3   2
     *      /     \
     *     5       9
     *    /         \
     *   6           7
     *
     *  正确答案
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.offer(new AnnotatedNode(root , 0 , 0));
        int maxWidth = 0 , curDeep = 0 , leftPosition = 0;
        while (!queue.isEmpty()){
            AnnotatedNode poll = queue.poll();
            if (poll.node != null){
                //记录当前一行二叉树的深度和当前节点的角标position
                queue.offer(new AnnotatedNode(poll.node.left , poll.deep + 1 , poll.position * 2));
                queue.offer(new AnnotatedNode(poll.node.right , poll.deep + 1 , poll.position * 2 + 1));

                if (curDeep != poll.deep){
                    //换行了
                    curDeep = poll.deep;
                    //最左边开始position
                    leftPosition = poll.position;
                }
                maxWidth = Math.max(maxWidth , poll.position - leftPosition + 1);
            }
        }

        return  maxWidth;
    }

    static class AnnotatedNode {
        TreeNode node;
        int deep, position;
        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            deep = d;
            position = p;
        }
    }


    /**
     * 没做出来
     */
    public int widthOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxWidth = 1;

        while (!queue.isEmpty()){
            if (queue.peekFirst() == null) {
                queue.pollFirst();
                continue;
            }
            if (queue.peekLast() == null) {
                queue.pollLast();
                continue;
            }
            /*
             *         1
             *        / \
             *       3   2
             *      /     \
             *     5       9
             *    /         \
             *   6           7
             */
            int size = queue.size();
            Deque<Integer> childDeque = new LinkedList<>();


            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                TreeNode left =  poll.left;
                TreeNode right = poll.right;

                if (left != null) queue.add(left);
                if (right != null) queue.add(right);

            }
            maxWidth = Math.max(maxWidth , childDeque.size());
        }

        return  maxWidth;
    }


    /*
     *         1
     *        / \
     *       3   2
     *      /     \
     *     5       9
     *    /         \
     *   6           7
     *
     *  正确答案
     */
    class Solution {
        int ans;
        Map<Integer, Integer> left;
        public int widthOfBinaryTree(TreeNode root) {
            ans = 0;
            left = new HashMap();
            dfs(root, 0, 0);
            return ans;
        }
        public void dfs(TreeNode root, int depth, int pos) {
            if (root == null) return;
            //表示查询集合中key对应的value,如果depth不存在或者对应的value为null,
            //则将pos和depth关联并添加到map集合中
            left.computeIfAbsent(depth, integer -> pos);
            ans = Math.max(ans, pos - left.get(depth) + 1);
            dfs(root.left, depth + 1, 2 * pos);
            dfs(root.right, depth + 1, 2 * pos + 1);
        }
    }




}
