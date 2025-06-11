package 数据结构_树.红黑树;

import java.util.Comparator;

/**
 * 日期 : 2020/9/5.
 * 创建 : xin.li
 * 描述 : AVL 平衡二叉搜索树
 */
class AVLTree<E> extends BBST<E> {

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
     * 旋转完成后更新各节点的父指针指向
     */
    @Override
    protected void afterRotate(Node<E> grand, Node<E> p, Node<E> child) {
        super.afterRotate(grand, p, child);
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

    @Override
    protected void rotate(Node<E> childRoot, Node<E> a, Node<E> b, Node<E> c, Node<E> d, Node<E> e, Node<E> f, Node<E> g) {
        super.rotate(childRoot, a, b, c, d, e, f, g);
        updateHeight(b);
        updateHeight(f);
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
