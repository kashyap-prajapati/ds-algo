package com.algorithm.tree.distance;

public class Main {
	
	static class TreeNode{
		int data;
		TreeNode left,right;
		public TreeNode(int data) {
			this.data=data;
			this.right=this.left=null;
		}
	}
	
	static int depthOfNode(TreeNode root,int height,int key) {
		if(root==null) 
			return 0;
		
		if(root.data==key) {
			return height;
		}
		
		int leftdistance = depthOfNode(root.left,height+1,key);
		int rightdistance = depthOfNode(root.right,height+1,key);
	
		if(leftdistance>0)
			return leftdistance;
		else
			return rightdistance;
			
		
	}
	
	static TreeNode commonAncestor(TreeNode root, int n1,int n2) {
		if(root==null) {
			return null;
		}
		
		if(root.data==n1 || root.data==n2)
			return root;
		
		TreeNode left =  commonAncestor(root.left, n1, n2);
		TreeNode right = commonAncestor(root.right, n1, n2);
		
		if(left!=null && right!=null) {
			return root;
		}
		return left!=null?left:right;
	}
	
	static int distanceNodes(TreeNode root, int n1, int n2) {
		int distance1 = depthOfNode(root, 1, n1);
		System.out.println(distance1);
		int distance2 = depthOfNode(root, 1, n2);
		System.out.println(distance2);
		TreeNode parent = commonAncestor(root, n1, n2);
		System.out.println(parent.data);
		int parentDistance = depthOfNode(root, 1, parent.data);
		return distance1 +  distance2 - (2*parentDistance);
	}
	
/*
 *      1 h=1
 *    2   5  h=2
 *  3   4 6  7 h=3
 * 
 * 
 */

	
	public static void main(String []args) {
		TreeNode root =  new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.left.right.right=new TreeNode(8);
		System.out.println(depthOfNode(root, 1, 9));
	}
}
