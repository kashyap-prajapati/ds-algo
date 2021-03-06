package com.algorithm.bst.kthsmallest;

import java.util.Stack;

public class Main {
	 static class TreeNode {
		 int data;
		 TreeNode left,right;
		 public TreeNode(int data) {
			 this.data=data;
			 this.left=this.right=null;
		 }
	 }
	 /*
	  * 	2
	  *    1 4
	  *     3 15
	  */	 	
	 static int currentIndex=1;
	 static void inorderTraversal(TreeNode root,int k) {
		 if(root==null)
			 return;
		 inorderTraversal(root.left,k);
		 if(currentIndex++==k) {
			 System.out.println(root.data);	 
		 }
		 inorderTraversal(root.right,k);
	 }
	 
	 static void inorderTraversalUsingStack(TreeNode root, int k) {
		 Stack<TreeNode>stack  = new Stack<>();
		 int i=1;
		 while(root!=null  || !stack.isEmpty()) {
			 while(root!=null) {
				 stack.push(root);
				 root=root.left;
			 }
			 root = stack.pop();
			 if(i==k) {
				 System.out.println(root.data); 
			 }
			i++;
			 root=root.right;
		 }
	 }
	 
	 public static void main(String []args) {
		 TreeNode root = new TreeNode(2);
		 root.left = new TreeNode(1);
		 root.right = new TreeNode(4);
		 root.right.left=new TreeNode(3);
		 root.right.right=new TreeNode(15);
		 inorderTraversalUsingStack(root,5);
		 
	 }

}
