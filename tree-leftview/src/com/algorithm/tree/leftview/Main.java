package com.algorithm.tree.leftview;

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
	static void leftview(TreeNode root,int level) {
		if(root==null)
			return;
		if(maxLevel<level) {
			System.out.print(root.key + " ");
			maxLevel=level;
		}
		leftview(root.left, level+1);
		leftview(root.right, level+1);
	}
	
	static void leftViewUsingQueue(TreeNode root) {
		if(root==null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int n=queue.size();
			for(int i=1;i<=n;i++) {
				TreeNode node = queue.poll();
				if(i==1) 
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
		root.right.left=new TreeNode(4);
		leftview(root, 1);
		System.out.println();
		leftViewUsingQueue(root);
	}
	
	
}
