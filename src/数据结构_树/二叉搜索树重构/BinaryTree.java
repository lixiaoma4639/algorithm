package 数据结构_树.二叉搜索树重构;

import java.util.LinkedList;
import java.util.Queue;

import 数据结构_树.二叉搜索树.printer.BinaryTreeInfo;

/**
 * 日期 : 2020/9/5.
 * 创建 : xin.li
 * 描述 :
 */
class BinaryTree<E> implements BinaryTreeInfo {
    protected int size;
    protected Node<E> root;

    // 元素的数量
    public int size() {
        return size;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 清空所有元素
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * 树的高度 , 所有节点高度中的最大值
     */
    public int height(){
//        return height(root);
        return height2(root);
    }
    /**
     * 节点的高度 , 从当前节点到最远叶子节点的路径上的节点总数
     */
    public int height(Node<E> node){
        if (node == null) return 0;
        return 1 + Math.max(height(node.left) , height(node.right));
    }
    /**
     * 节点的高度 , 从当前节点到最远叶子节点的路径上的节点总数
     */
    public int height2(Node<E> node){
        if (node == null) return 0;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        int height = 0 , levelRowSize = 1;
        while (queue.peek() != null) { //或者使用 !queue.isEmpty()
            Node<E> poll = queue.poll();
            levelRowSize--;

            Node<E> left = poll.left;
            Node<E> right = poll.right;
            if (left != null) queue.add(left);
            if (right != null) queue.add(right);

            if (levelRowSize == 0){
                height++;
                levelRowSize = queue.size();
            }
        }

        return height;
    }




    /**
     * 是否是完全二叉树
     * @return true 是
     */
    public boolean isComplete2(){
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        boolean isLeaf = false;

        while (!queue.isEmpty()){
            Node<E> poll = queue.poll();
            if (isLeaf && !poll.isLeaf()){
                return false;
            }

            if (poll.hasTwoChild()){
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            } else if (poll.left == null && poll.right != null){
                return false;
            } else {
                if (poll.left != null) queue.add(poll.left);
                isLeaf = true;
            }
        }
        return true;
    }

    /**
     * 是否是完全二叉树 , 叶子节点只会出现最后 2 层，且最后 1 层的叶子结点都靠左对齐
     * @return true 是
     */
    public boolean isComplete(){
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeaf = false;

        while (!queue.isEmpty()){
            Node<E> poll = queue.poll();
            if (isLeaf && !poll.isLeaf()) return false;
            Node<E> left = poll.left;
            Node<E> right = poll.right;
            if (left != null){
                queue.add(left);
            } else if (right != null){
                //left == null && right != null
                return false;
            }
            if (right != null){
                queue.add(right);
            } else {
                //left == null / left != null && right == null
                isLeaf = true;
            }
        }
        return true;
    }

    /**
     * 前序遍历 , 首先打印的是根节点
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node<E> node) {
        if (node == null) return;
        System.out.println(node.element.toString());
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }


    /**
     * 中序遍历 , 根节点在中间打印
     */
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<E> node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.println(node.element);
        inOrderTraversal(node.right);
    }

    /**
     * 后序遍历, 根节点在最后打印
     */
    public void lastOrderTraversal() {
        lastOrderTraversal(root);
    }

    private void lastOrderTraversal(Node<E> node) {
        if (node == null) return;
        lastOrderTraversal(node.left);//node = 2
        lastOrderTraversal(node.right);
        System.out.println(node.element);
    }

    /**
     * 层级遍历 , 这是自己写出来的哦
     */
    public void levelOrderTraversal() {
        if (root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (queue.peek() != null) { //或者使用 !queue.isEmpty()
            Node<E> poll = queue.poll();
            System.out.println(poll.element);
            Node<E> left = poll.left;
            Node<E> right = poll.right;
            if (left != null) queue.add(left);
            if (right != null) queue.add(right);
        }
    }

    /**
     * 层级遍历 , 将遍历出的结果返回给调用者
     */
    public void levelOrder(BST.Visitor<E> visitor){
        if (root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (queue.peek() != null) { //或者使用 !queue.isEmpty()
            Node<E> poll = queue.poll();
            visitor.visit(poll.element);
            Node<E> left = poll.left;
            Node<E> right = poll.right;
            if (left != null) queue.add(left);
            if (right != null) queue.add(right);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(BST.Visitor<E> visitor){
        if (visitor == null) return;
        preOrder(root , visitor);
    }
    private void preOrder(Node<E> node , BST.Visitor<E> visitor){
        if (node == null ) return;
        if (visitor.stop) return; //停止遍历
        visitor.stop = visitor.visit(node.element);
        preOrder(node.left , visitor);
        preOrder(node.right , visitor);
    }

    /**
     * 中序遍历
     */
    public void inOrder(BST.Visitor<E> visitor){
        if (visitor == null) return;
        inOrder(root , visitor);
    }
    private void inOrder(Node<E> node , BST.Visitor<E> visitor){
        if (node == null || visitor.stop) return;
        inOrder(node.left , visitor);
        if (visitor.stop) return; //停止遍历
        visitor.stop = visitor.visit(node.element);
        inOrder(node.right , visitor);
    }

    /**
     * 后序遍历
     */
    public void lastOrder(BST.Visitor<E> visitor){
        if (visitor == null) return;
        lastOrder(root , visitor);
    }
    private void lastOrder(Node<E> node , BST.Visitor<E> visitor){
        if (node == null || visitor.stop) return;
        lastOrder(node.left , visitor);
        lastOrder(node.right , visitor);
        if (visitor.stop) return; //停止遍历
        visitor.stop = visitor.visit(node.element);
    }

    /**
     * 将遍历的结果传递给调用者
     */
    static abstract class Visitor<E> implements IVisitor<E>{
        boolean stop;
    }
    static interface IVisitor<E>{
        boolean visit(E element);
    }

    /**
     * 获取前驱节点:中序遍历时的前一个节点
     */
    protected Node<E> predecessor(Node<E> node){
        if (node == null) return null;
        Node<E> pre = node.left;
        if (pre != null){
            while (pre.right != null){
                pre = pre.right;
            }
            return pre;
        }

        while (node.parent != null && node == node.parent.right){
            node = node.parent;
        }

        return node.parent;
    }

    /**
     * 获取后继节点:中序遍历时的前一个节点
     */
    protected Node<E> successor(Node<E> node){
        if (node == null) return null;
        Node<E> suc = node.right;
        if (suc != null){
            while (suc.left != null){
                suc = suc.left;
            }
            return suc;
        }

        while (node.parent != null && node == node.parent.left){
            node = node.parent;
        }

        return node.parent;
    }



    void checkElement(E element) {
        if (element == null) throw new IllegalArgumentException("非法的参数异常");
    }

    /**
     * 节点
     */
    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }

        public boolean hasTwoChild(){
            return left != null && right != null;
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node myNode = ((Node<E>) node);
        String printStr = null;
        if (myNode.parent != null) {
            printStr = myNode.parent.element.toString();
        }
        return myNode.element.toString() + ";p(" + printStr + ")";
    }
}
