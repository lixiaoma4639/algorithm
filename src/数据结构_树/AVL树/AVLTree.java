package 数据结构_树.AVL树;

import java.util.Comparator;

/**
 * 日期 : 2020/9/5.
 * 创建 : xin.li
 * 描述 : AVL 平衡二叉搜索树
 */
class AVLTree<E> extends BST<E> {

    public AVLTree() {
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        while ((node = node.parent) != null){
            if (isBalance(node)){
                //平衡, 更新当前node的高度
                updateHeight(node);
            } else {
                //不平衡,恢复平衡
                reBalance(node);
                break;
            }
        }
    }

    @Override
    protected void afterRemove(Node<E> node) {
        while ((node = node.parent) != null){
            if (isBalance(node)){
                //平衡, 更新当前node的高度
                updateHeight(node);
            } else {
                //不平衡,恢复平衡
                reBalance(node);
            }
        }
    }

    /**
     * 恢复平衡
     * @param grandParent 不平衡的高度最低的一个节点
     */
    private void reBalance2(Node<E> grandParent) {
        Node<E> parenNode = ((AVLNode<E>) grandParent).tallerChild();
        Node<E> node = ((AVLNode<E>) parenNode).tallerChild();
        //旋转
        if (parenNode.isLeftOfParent()){//L
            if (node.isLeftOfParent()){
                //LL 使用右旋
                rightRotate(grandParent);
            } else {
                //LR 先左旋后右旋
                leftRotate(parenNode);
                rightRotate(grandParent);
            }
        } else { //R
            if (node.isLeftOfParent()) {
                // RL 先右旋后左旋
                rightRotate(parenNode);
                leftRotate(grandParent);
            } else {
                // RR 使用左旋
                leftRotate(grandParent);
            }
        }
    }

    /**
     * 右旋转
     */
    private void rightRotate(Node<E> grand){
        Node<E> p = grand.left;
        Node<E> child = p.right;
        grand.left = child;
        p.right = grand;


        //判断grand节点是父节点的左子树还是右子树
        afterRotate(grand , p , child);
    }

    /**
     * 左旋转
     */
    private void leftRotate(Node<E> grand){
        Node<E> p = grand.right;
        Node<E> child = p.left;
        grand.right = child;
        p.left = grand;

        //判断grand节点是父节点的左子树还是右子树
        afterRotate(grand , p , child);
    }

    /**
     * 旋转完成后更新各节点的父指针指向
     */
    private void afterRotate(Node<E> grand , Node<E> p , Node<E> child){
        //判断grand节点是父节点的左子树还是右子树
        p.parent = grand.parent;
        if (grand.isLeftOfParent()){
            grand.parent.left = p;
        } else if (grand.isRightOfParent()){
            grand.parent.right = p;
        } else {
            root = p;
        }

        if (child != null) child.parent = grand;
        grand.parent = p;

        updateHeight(grand);
        updateHeight(p);
    }


    /**
     * 恢复平衡
     * @param grandParent 不平衡的高度最低的一个节点
     */
    private void reBalance(Node<E> grandParent) {
        Node<E> parenNode = ((AVLNode<E>) grandParent).tallerChild();
        Node<E> node = ((AVLNode<E>) parenNode).tallerChild();
        //旋转
        if (parenNode.isLeftOfParent()){//L
            if (node.isLeftOfParent()){
                //LL 使用右旋
                rotate(grandParent , node.left , node , node.right , parenNode , parenNode.right , grandParent , grandParent.right);
            } else {
                //LR 先左旋后右旋
                rotate(grandParent , parenNode.left , parenNode , node.left , node, node.right , grandParent , grandParent.right);
            }
        } else { //R
            if (node.isLeftOfParent()) {
                // RL 先右旋后左旋
                rotate(grandParent , grandParent.left , grandParent , node.left , node , node.right , parenNode , parenNode.right);
            } else {
                // RR 使用左旋
                rotate(grandParent , grandParent.left , grandParent , parenNode.left , parenNode , node.left , node , node.right);
            }
        }
    }

    private void rotate(
            Node<E> childRoot ,
            Node<E> a , Node<E> b , Node<E> c ,
            Node<E> d ,
            Node<E> e , Node<E> f , Node<E> g){

        //使d成为该子树的根节点
        d.parent = childRoot.parent;
        if (childRoot.isLeftOfParent()){
            childRoot.parent.left = d;
        } else if (childRoot.isRightOfParent()){
            childRoot.parent.right = d;
        } else {
            root = d;
        }


        //a b c
        b.left = a;
        if (a != null) a.parent = b;
        b.right = c;
        if (c != null) c.parent = b;
        updateHeight(b);


        //e f g
        f.left = e;
        if (e != null) e.parent = f;
        f.right = g;
        if (g != null) g.parent = f;
        updateHeight(f);

        //d b f
        d.left = b;
        b.parent = d;
        d.right = f;
        f.parent = d;
        updateHeight(d);
    }

    /**
     * 更新当前node的高度
     */
    private void updateHeight(Node<E> node){
        ((AVLNode)node).updateHeight();
    }

    /**
     * 根据平衡因子计算 是否是平衡二叉树
     */
    private boolean isBalance(Node<E> node){
        return Math.abs(((AVLNode)node).balanceFactory()) <= 1;
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }




    private static class AVLNode<E> extends Node<E>{
        int height = 1;

        AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        int balanceFactory(){
            int leftHeight = left == null ? 0 : ((AVLNode)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode)right).height;
            return leftHeight - rightHeight;
        }

        void updateHeight(){
            int leftHeight = left == null ? 0 : ((AVLNode)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode)right).height;
            height = 1 + Math.max(leftHeight , rightHeight);
        }

        Node<E> tallerChild(){
            int leftHeight = left == null ? 0 : ((AVLNode)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode)right).height;
            if (leftHeight > rightHeight) return left;
            if (leftHeight < rightHeight) return right;
            return isLeftOfParent() ? left : right;
        }

        @Override
        public String toString() {
            String printStr = null;
            if (parent != null) {
                printStr = parent.element.toString();
            }
            return element.toString() + ";p(" + printStr + ")" + ";h(" + height + ")";
        }
    }
}
