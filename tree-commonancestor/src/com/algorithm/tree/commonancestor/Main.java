package com.algorithm.tree.commonancestor;

public class Main {
	
	static class TreeNode{
		int data;
		TreeNode left,right;
		
		public TreeNode(int data) {
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	static TreeNode commonAncestor(TreeNode root,int n1,int n2) {
		if(root==null) {
			return null;
		}
		if(root.data == n1 || root.data == n2)
			return root;
		
		TreeNode left = commonAncestor(root.left,n1,n2);
		TreeNode right = commonAncestor(root.right,n1,n2);
		
		if(left!=null && right!=null)
			return root;
	
		return (left != null) ? left : right;
	}
	
	public static void main(String []args) {
		TreeNode root= new TreeNode(1);
		root.left=new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(commonAncestor(root, 1, 1).data);
	}

}
