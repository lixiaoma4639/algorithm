package 练习.二叉树.普通;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 日期 : 2020/10/16.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * <p>
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 *              1
 *      3       2            4
 * 5       6
 * <p>
 * 我们应返回其最大深度，3。
 * <p>
 * 说明:
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 */
class _559_N叉树的最大深度 {

    /**
     * 解法一
     */
    public int maxDepth2(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int deep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                for (Node node : poll.children) {
                    queue.offer(node);
                }
            }
            deep++;
        }
        return deep;
    }

    /**
     * 解法二
     */
    public int maxDepth3(Node root) {
        if (root == null) return 0;
        Queue<DeepNode> queue = new LinkedList<>();
        queue.add(new DeepNode(root , 1));

        int maxDeep = 0;
        while (!queue.isEmpty()) {
            DeepNode poll = queue.poll();
            for (Node node : poll.node.children) {
                queue.offer(new DeepNode(node , poll.deep + 1));
            }
            maxDeep = Math.max( maxDeep , poll.deep);
        }

        return maxDeep;
    }
    class DeepNode{
        Node node;
        int deep;

        public DeepNode(Node node, int deep) {
            this.node = node;
            this.deep = deep;
        }
    }


    /**
     * 解法三
     * 时间和空间负责度都为N
     */
    int mDeep;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        mDeep = 0;
        recursion(root , mDeep);
        return mDeep;
    }
    private void recursion(Node node , int deep ){
        if (node.children == null) return;
        mDeep = Math.max(mDeep , ++deep);
        for (Node childNode : node.children) {
            recursion(childNode , deep);
        }
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
