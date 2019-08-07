package com.cnipr.open.ms.test.pd.learn;

/**
 * 给定一棵平衡二叉树，判断它是否是高度平衡的。一棵高度平衡的二叉树是左右子树的高度相差不超过1，对其左右子树也是如此。
 * 递归分治法求解。
 *
 * @author Bi Yunfei
 * @date 2019/8/7 13:46
 */
public class BalanceBinaryTree {

	private BalanceBinaryTree() {
	}

	public static boolean isBalance(TreeNode node) {
		if (node == null) return false;
		int left = depth(node.left);
		int right = depth(node.right);
		if (left - right > 1 || left - right < -1) {
			return false;
		} else {
			return isBalance(node.left) && isBalance(node.right);
		}
	}

	public static int depth(TreeNode node) {
		if (node == null) return 0;
		if (node.left == null && node.right == null) {
			return 1;
		} else {
			int left = depth(node.left);
			int right = depth(node.right);
			return 1 + (left > right ? left : right);
		}
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(32);
		TreeNode node3 = new TreeNode(14);
		TreeNode node4 = new TreeNode(52);
		TreeNode node5 = new TreeNode(6);
		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		boolean flag = isBalance(node);
		System.out.println(flag);
	}

}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;

	TreeNode(int value) {
		this.value = value;
	}
}
