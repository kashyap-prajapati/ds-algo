package com.algorithm.tree.height;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class TreeNode{
		int data;
		TreeNode left,right;
		
		public TreeNode(int key) {
			this.data=key;
			this.left=this.right=null;
		}
	}
	
	static int heightOfTree(TreeNode root) {
		if(root==null)
			return 0;
		int left = heightOfTree(root.left);
		int right = heightOfTree(root.right);
		
		if(left>right)
			return left+1;
		return right+1;
	}
	
	
	static int heightOfTreeUsingQueue(TreeNode root) {
		Queue<TreeNode> queue =  new LinkedList<>();
		queue.add(root);
		int depth = 0;
		while(!queue.isEmpty()) {
			depth++;
			for(int i=0;i<queue.size();i++) {
				TreeNode node = queue.poll();
				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
			}
		}
		return depth;
	}
	
	public static void main(String []args) {
		TreeNode root =  new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);

		System.out.println(heightOfTree(root));
		System.out.println(heightOfTreeUsingQueue(root));
	}
}
