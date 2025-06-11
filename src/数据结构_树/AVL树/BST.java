package 数据结构_树.AVL树;

import java.util.Comparator;


/**
 * 日期 : 2020/8/23.
 * 创建 : xin.li
 * 描述 : 二叉搜索树
 */
class BST<E> extends BinaryTree<E> {

    private Comparator<E> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
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
            root = createNode(element , null);
            size++;
            afterAdd(root);
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

        Node<E> addNode = createNode(element, parentNode);
        if (compare(element, parentNode.element) > 0) {
            parentNode.right = addNode;
        } else {
            parentNode.left = addNode;
        }

        afterAdd(addNode);
    }

    /**
     * add之后的一些处理
     */
    protected void afterAdd(Node<E> node){}

    private int compare(E e1, E e2) {
        if (comparator != null) {
            comparator.compare(e1, e2);
        }
        return ((Comparable) e1).compareTo(e2);
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

        afterRemove(node);
    }

    /**
     * 处理删除节点之后的动作
     * @param node 被删除的节点
     */
    protected void afterRemove(Node<E> node) {}

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
}
