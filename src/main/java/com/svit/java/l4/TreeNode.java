package com.svit.java.l4;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return "TreeNode: [val = " + val + " left child = " + this.left + " right child = " + this.right ;
	}
}
