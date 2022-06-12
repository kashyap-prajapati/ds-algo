package com.algorithm.treesort;

public class Main {
	
	static TreeNode binarySearchTree(TreeNode root, int key) {
		if(root==null) return new TreeNode(key);
		if(key<root.value) {
			root.left=binarySearchTree(root.left, key);
		}else if(key>root.value) {
			root.right=binarySearchTree(root.right, key);
		}
		return root;
	}
	
	static void inorderTraversal(TreeNode root)
	    {
	        if (root != null)
	        {
	        	inorderTraversal(root.left);
	            System.out.print(root.value + " ");
	            inorderTraversal(root.right);
	        }
	    }
	
	static void treeSort(int []arr) {
		TreeNode root = new TreeNode(arr[0]);
		for(int i=1;i<arr.length;i++)
			root=binarySearchTree(root, arr[i]);
		inorderTraversal(root);
	}

	public static void main(String[]args) {
		int []a = {9,2,5,1,22};
		treeSort(a);
	}
}
