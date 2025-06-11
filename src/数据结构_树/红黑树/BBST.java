package 数据结构_树.红黑树;

import java.util.Comparator;

/**
 * 日期 : 2021/3/6.
 * 创建 : xin.li
 * 描述 : 平衡二叉搜索树 , AVL 树和 红黑树都是平衡二叉搜索树
 */
class BBST<E> extends BST<E> {

    public BBST() {
        this(null);
    }

    public BBST(Comparator<E> comparator) {
        super(comparator);
    }

    /**
     * 右旋转
     */
    protected void rightRotate(Node<E> grand) {
        Node<E> p = grand.left;
        Node<E> child = p.right;
        grand.left = child;
        p.right = grand;


        //判断grand节点是父节点的左子树还是右子树
        afterRotate(grand, p, child);
    }

    /**
     * 左旋转
     */
    protected void leftRotate(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;
        grand.right = child;
        parent.left = grand;
        //判断grand节点是父节点的左子树还是右子树
        afterRotate(grand, parent, child);
    }


    /**
     * 旋转完成后更新各节点的父指针指向
     */
    protected void afterRotate(Node<E> grand, Node<E> p, Node<E> child) {
        //判断grand节点是父节点的左子树还是右子树
        p.parent = grand.parent;
        if (grand.isLeftOfParent()) {
            grand.parent.left = p;
        } else if (grand.isRightOfParent()) {
            grand.parent.right = p;
        } else {
            root = p;
        }

        if (child != null) child.parent = grand;
        grand.parent = p;

    }

    protected void rotate(
            Node<E> childRoot,
            Node<E> a, Node<E> b, Node<E> c,
            Node<E> d,
            Node<E> e, Node<E> f, Node<E> g) {

        //使d成为该子树的根节点
        d.parent = childRoot.parent;
        if (childRoot.isLeftOfParent()) {
            childRoot.parent.left = d;
        } else if (childRoot.isRightOfParent()) {
            childRoot.parent.right = d;
        } else {
            root = d;
        }


        //a b c
        b.left = a;
        if (a != null) a.parent = b;
        b.right = c;
        if (c != null) c.parent = b;


        //e f g
        f.left = e;
        if (e != null) e.parent = f;
        f.right = g;
        if (g != null) g.parent = f;

        //d b f
        d.left = b;
        b.parent = d;
        d.right = f;
        f.parent = d;
    }
}
