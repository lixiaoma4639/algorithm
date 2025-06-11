package 数据结构_树.二叉搜索树;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import 数据结构_树.二叉搜索树.printer.BinaryTreeInfo;

/**
 * 日期 : 2020/8/23.
 * 创建 : xin.li
 * 描述 : 二叉搜索树
 */
public class SearchBinaryTree<E> implements BinaryTreeInfo {

    private int size;
    private Node<E> root;

    private Comparator<E> comparator;

    public SearchBinaryTree() {
        this(null);
    }

    public SearchBinaryTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

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

    //是否包含
    public boolean contain(E element){
        return node(element) != null;
    }

    // 添加元素
    public void add(E element) {
        checkElement(element);

        if (root == null) {
            //添加第一个节点,也就是根节点
            root = new Node<>(element, null);
            size++;
            return;
        }

        Node<E> parentNode = root;
        Node<E> compareNode = root;
        //添加子节点
        while (compareNode != null) {
            int compare = compare(element, compareNode.element);
            parentNode = compareNode;
            if (compare > 0) {
                compareNode = compareNode.right;
            } else if (compare < 0) {
                compareNode = compareNode.left;
            } else {
                compareNode.element = element;
                return;
            }
        }

        if (compare(element, parentNode.element) > 0) {
            parentNode.right = new Node<>(element, parentNode);
        } else {
            parentNode.left = new Node<>(element, parentNode);
        }
    }

    private int compare(E e1, E e2) {
        if (comparator != null) {
            comparator.compare(e1, e2);
        }
        return ((Comparable) e1).compareTo(e2);
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
            System.out.print(poll.element + " ");
            Node<E> left = poll.left;
            Node<E> right = poll.right;
            if (left != null) queue.add(left);
            if (right != null) queue.add(right);
        }
    }

    /**
     * 层级遍历 , 将遍历出的结果返回给调用者
     */
    public void levelOrder(Visitor<E> visitor){
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


    void levelOrder2(Node<E> node){
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node<E> poll = queue.poll();
            System.out.println(poll.element);
            queue.add(poll.left);
            queue.add(poll.right);
        }
    }

    /**
     * 递归前序遍历
     */
    public void preOrder(Visitor<E> visitor){
        if (visitor == null) return;
        preOrder(root , visitor);
    }
    private void preOrder(Node<E> node , Visitor<E> visitor){
        if (node == null ) return;
        if (visitor.stop) return; //停止遍历
        visitor.stop = visitor.visit(node.element);
        preOrder(node.left , visitor);
        preOrder(node.right , visitor);
    }
    //循环 前序遍历
    public void preOrderCircle(Visitor<E> visitor){
        if (visitor == null ) return;
        if (root == null ) return;
        Stack<Node<E>> rightStack = new Stack<>();
        Node<E> node = root;
        while (true){
            if (node != null){
                if (visitor.visit(node.element)) return;
                if (node.right != null) rightStack.add(node.right);
                node = node.left;
            } else if (rightStack.isEmpty()){
                return;
            } else {
                node = rightStack.pop();
            }
        }
    }


    /**
     * 中序遍历 递归
     */
    public void inOrder(Visitor<E> visitor){
        if (visitor == null) return;
        inOrder(root , visitor);
    }
    private void inOrder(Node<E> node , Visitor<E> visitor){
        if (node == null || visitor.stop) return;
        inOrder(node.left , visitor);
        if (visitor.stop) return; //停止遍历
        visitor.stop = visitor.visit(node.element);
        inOrder(node.right , visitor);
    }
    /**
     * 中序遍历 循环
     */
    public void inOrderCircle(Visitor<E> visitor){
        if (root == null || visitor == null) return;
        Stack<Node<E>> inStack = new Stack<>();
        Node<E> node = root;
        while (true){
            if (node != null){
                inStack.add(node);
                node = node.left;
            } else if (inStack.isEmpty()){
                return;
            } else {
                //取出中序节点
                node = inStack.pop();
                if (visitor.visit(node.element)) return;
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历 递归
     */
    public void lastOrder(Visitor<E> visitor){
        if (visitor == null) return;
        lastOrder(root , visitor);
    }
    private void lastOrder(Node<E> node , Visitor<E> visitor){
        if (node == null || visitor.stop) return;
        lastOrder(node.left , visitor);
        lastOrder(node.right , visitor);
        if (visitor.stop) return; //停止遍历
        visitor.stop = visitor.visit(node.element);
    }

    /**
     * 后序遍历 循环
     */
    public void lastOrderCircle(Visitor<E> visitor){
        if (root == null || visitor == null) return;
        Node<E> pre = null;
        Stack<Node<E>> lastStack = new Stack<>();
        lastStack.push(this.root);
        while (!lastStack.isEmpty()){
            Node<E> top = lastStack.peek();
            if (top.isLeaf() || (pre != null && pre.parent == top)){
                pre = lastStack.pop();
                if (visitor.visit(pre.element)) return;
            } else {
                Node<E> right = top.right;
                if (right != null){
                    lastStack.push(right);
                }
                Node<E> left = top.left;
                if (left != null){
                    lastStack.push(left);
                }
            }
        }

    }


    private void checkElement(E element) {
        if (element == null) throw new IllegalArgumentException("非法的参数异常");
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
     * 获取前驱节点:中序遍历时的前一个节点
     */
    public Node<E> predecessor(Node<E> node){
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
    public Node<E> successor(Node<E> node){
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

    /**
     * 删除节点
     */
    public void remove(E element){
        Node<E> node = node(element);
        if (node == null) return;

        size -- ;

        if (node.hasTwoChild()){
            //度为2的节点,首先找到后继节点
            Node<E> successor = successor(node);
            //替换node中的元素
            node.element = successor.element;
            //删除后继节点
            node = successor;
        }

        //来到此处 : 度为1的节点 或者是 叶子节点
        //获取node的子节点
        Node<E> childNode = node.left != null ? node.left : node.right;
        //判断子节点是left还right 或者是null
        if (childNode != null){
            //跳过node节点互相相认
            childNode.parent = node.parent;
            //子节点为空, 那就是叶子节点了 , 删除叶子节点
            if (node.parent == null){
                //根节点且只有一个子节点
                root = childNode;
            } else if (node == node.parent.right){
                //node节点是父节点的右子树
                node.parent.right = childNode;
            } else {
                //node节点是父节点的左子树
                node.parent.left = childNode;
            }

        } else if (node.parent == null){
            //子节点为空, 父节点也为空, 必然是root根节点了
            root = null;
        } else {
            //子节点为空, 那就是叶子节点了 , 删除叶子节点
            if ( node == node.parent.right){
                //叶子节点是父节点的右子树
                node.parent.right = null;
            } else {
                //叶子节点是父节点的左子树
                node.parent.left = null;
            }
        }
    }

    private Node<E> node(E element){
        if (root == null) return null;
        Node<E> node = root;
        while (node != null){
            int compare = compare(node.element, element);
            if (compare == 0) return node;
            if (compare > 0){
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }


    /**
     * 节点
     */
    private static class Node<E> {
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


    /**
     * 将遍历的结果传递给调用者
     */
    static abstract class Visitor<E> implements IVisitor<E>{
        boolean stop;
    }
    static interface IVisitor<E>{
        boolean visit(E element);
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
//        return myNode.element.toString();
    }
}
