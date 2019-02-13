package com.svit.java.l4;
/**
 * Definition for binary tree
 * e.g                  1
 *                   /    \
 *                  2      3
 *                 / \    /
 *                4   5  6
 *               /
 *              7
 * @author sv-it
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreeInOrderTraversal
{
    public static void main(String[] args)
    {
    	TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.left = node7;
        
        System.out.println(inorderTraversalIterative(node1));
        System.out.println(inorderTraversalRecursive(node1));
        System.out.println(inorderTraversalRecursive1(node1));
        
    } 	
    
    /**
     * ITERATIVE: in order travel with stack
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (root==null) return result;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        
        //cur!=null when root or not the left leaf
        while(!s.isEmpty() || cur!=null){
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                cur = s.pop();
                result.add(cur.val);
                cur = cur.right;
            }
            
        }
        
        return result;
    }
    

	
	/**
	 * RECURSIVE without return: in order travel
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> inorderTraversalRecursive(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	    inorderTraversalRecursiveHelper(root, result);
	    
	    return result;
	    
	}
	
	public static void inorderTraversalRecursiveHelper(TreeNode cur, ArrayList<Integer> result){
		if (cur==null) 
			return;
		
		inorderTraversalRecursiveHelper(cur.left, result);
		result.add(cur.val);
		inorderTraversalRecursiveHelper(cur.right, result);
		
	}
    
    
	/**
	 * RECURSIVE WITH return: in order travel
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> inorderTraversalRecursive1(TreeNode root) {
	    
	    
	   return inorderTraversalRecursiveHelper1(root);
	    
	}
	
	public static ArrayList<Integer> inorderTraversalRecursiveHelper1(TreeNode cur){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (cur==null) 
			return result;
		
		result.addAll(inorderTraversalRecursiveHelper1(cur.left));
		result.add(cur.val);
		result.addAll(inorderTraversalRecursiveHelper1(cur.right));
		
		return result;
	}    
    

}

