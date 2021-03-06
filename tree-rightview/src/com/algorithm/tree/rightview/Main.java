package com.algorithm.tree.rightview;

import java.util.LinkedList;
import java.util.Queue;


public class Main {
	static class TreeNode{
		int key;
		TreeNode left,right;
		
		public TreeNode(int key) {
			this.key=key;
			this.left=this.right=null;
		}
	}
	
	static int maxLevel=0;
	static void rightview(TreeNode root,int level) {
		if(root==null)
			return;
		if(maxLevel<level) {
			System.out.print(root.key + " ");
			maxLevel=level;
		}
		rightview(root.right, level+1);
		rightview(root.left, level+1);
	}
	
	static void rightViewUsingQueue(TreeNode root) {
		if(root==null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int n=queue.size();
			for(int i=0;i<n;i++) {
				TreeNode node = queue.peek();
				queue.remove();
				if(i==n-1) 
					System.out.print(node.key+" ");
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
				
			}
		}
	}
	
	public static void main(String []args) {
		TreeNode root =  new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(5);
		root.right.right=new TreeNode(4);
		rightview(root, 1);
		System.out.println();
		rightViewUsingQueue(root);
	}
	
}
