package com.algorithm.tree.levelordertraversal;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class TreeNode {
		int data;
		TreeNode left,right;
		
		public TreeNode(int data) {
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	static void levelOrderTraversal(TreeNode root) {
		int height = heightOfTree(root);
		for(int i=1;i<=height;i++) {
			printOrderTraversal(root, i);
		}
	}
	
	static void printOrderTraversal(TreeNode root, int level) {
		if(root==null) {
			return;
		}
		if(level==1) {
			System.out.print(root.data+"  ");
		}
		printOrderTraversal(root.left, level-1);
		printOrderTraversal(root.right, level-1);
	}
	
	static int heightOfTree(TreeNode root) {
		if(root==null)
			return 0;
		int left = heightOfTree(root.left);
		int right = heightOfTree(root.right);
		return left>right?1+left:1+right;
	}
	
	static void printOrderTraversalUsingQueue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.data+" ");
			if(node.left!=null)
				queue.add(node.left);
			if(node.right!=null)
				queue.add(node.right);
		}
	}
	
	public static void main(String []args) {
		TreeNode root =  new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		levelOrderTraversal(root);	
		System.out.println();
		printOrderTraversalUsingQueue(root);
	}
}
