package 数据结构_树.二叉搜索树.printer;

/**
 * 一个打印二叉搜索树的工具类
 */
public interface BinaryTreeInfo {
	/**
	 * who is the root node
	 */
	Object root();
	/**
	 * how to get the left child of the node
	 */
	Object left(Object node);
	/**
	 * how to get the right child of the node
	 */
	Object right(Object node);
	/**
	 * how to print the node
	 */
	Object string(Object node);
}
