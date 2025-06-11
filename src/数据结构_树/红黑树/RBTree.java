package 数据结构_树.红黑树;

import java.util.Comparator;

/**
 * 日期 : 2021/3/6.
 * 创建 : xin.li
 * 描述 : 红黑树实现
 */
class RBTree<E> extends BBST<E> {

    public RBTree() {
        this(null);
    }

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;
        if (parent == null){
            //添加的是根节点
            black(node);
            return;
        }

        //父节点是黑色
        if (isBlack(parent)) return;

        //父节点和叔父节点都是红色
        Node<E> uncle = parent.sibling();
        Node<E> grand = parent.parent;
        if (isRed(uncle)){
            black(parent);
            black(uncle);
            afterAdd(red(grand));
            return;
        }

        //父节点是红色, 叔父节点是黑色
        if (parent.isLeftChild()){ //L
            red(grand);
            if (node.isLeftChild()){ //LL
                black(parent);
            } else { //LR
                black(node);
                leftRotate(parent);
            }
            rightRotate(grand);
        } else { //R
            red(grand);
            if (node.isLeftChild()){ //RL
                black(node);
                rightRotate(parent);
            } else { //RR
                black(parent);
            }
            leftRotate(grand);
        }
    }

    @Override
    protected void afterRemove(Node<E> node) {

        //删除了一个拥有红色子节点的黑色节点 或者 删除了红色叶子节点
        if (isRed(node)){
            black(node);
            return;
        }
        //删除的是根节点
        Node<E> parent = node.parent;
        if (parent == null) return;

        //以下都是删除了 黑色叶子节点的情况
        boolean isLeft =  parent.left == null || node.isLeftChild();
        Node<E> sibling = isLeft ? parent.right : parent.left;//弟兄节点
        if (isLeft){
            //被删除的是左边的叶子节点
            //被删除的是右边的叶子节点

            if (isRed(sibling)){
                //兄弟节点是红色
                black(sibling);
                red(parent);
                leftRotate(parent);
                sibling = parent.right;
            }

            //兄弟节点是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)){
                //兄弟节点的子节点也是是黑色(此处其实是假象的最后一层null节点)
                boolean isBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (isBlack){
                    afterRemove(parent);
                }

            } else {
                //兄弟节点的子节点至少有一个红色
                if (isBlack(sibling.right)){
                    rightRotate(sibling);
                    sibling = parent.right;
                }

                color(sibling , colorOf(parent));
                black(sibling.right);
                black(parent);
                leftRotate(parent);

            }
        } else {
            //被删除的是右边的叶子节点

            if (isRed(sibling)){
                //兄弟节点是红色
                black(sibling);
                red(parent);
                rightRotate(parent);
                sibling = parent.left;
            }

            //兄弟节点是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)){
                //兄弟节点的子节点也是是黑色(此处其实是假象的最后一层null节点)
                boolean isBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (isBlack){
                    afterRemove(parent );
                }
            } else {
                //兄弟节点的子节点至少有一个红色
                if (isBlack(sibling.left)){
                    leftRotate(sibling);
                    sibling = parent.left;
                }

                color(sibling , colorOf(parent));
                black(sibling.left);
                black(parent);
                rightRotate(parent);

            }
        }

    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RBNode<E>(element, parent);
    }

    private Node<E> color(Node<E> node, boolean color) {
        if (node == null) return null;
        ((RBNode<E>)node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node) {
        return color(node, RED);
    }

    private Node<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RBNode<E>)node).color;
    }

    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    private boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }

    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private static class RBNode<E> extends Node<E> {
        boolean color = RED;
        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str = "";
            if (color == RED) {
                str = "R_";
            }
            return str + element.toString();
        }
    }
}
