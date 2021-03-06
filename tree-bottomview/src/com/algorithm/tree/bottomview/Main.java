package com.algorithm.tree.bottomview;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Main {

	
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		public TreeNode(int data) {
			this.data=data;
		}
	}
	
	static class Node{
		TreeNode node;
		int distance;
		Node(TreeNode node,int distance){
			this.node=node;
			this.distance=distance;
		}
	}
	
	static void levelOrderTraversal(TreeNode root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(root,0));
		Map<Integer, Node> map = new TreeMap<>();
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			map.put(node.distance, node);
		
			if(node.node.right!=null) {
				queue.add(new Node(node.node.right, node.distance+1));
			}
			if(node.node.left!=null) {
				queue.add(new Node(node.node.left, node.distance-1));
			}
		}
		for(Integer i : map.keySet()) {
			System.out.print(map.get(i).node.data+" ");
		}
	}
	/*
	 * 			1
	 * 		2 	 	3
	 * 	        4
	 */
	
	public static void main(String []args) {
		TreeNode root = new TreeNode(1);
		root.left =new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right =new TreeNode(4);
		root.right.left = new TreeNode(5);
		levelOrderTraversal(root);
	}
}
