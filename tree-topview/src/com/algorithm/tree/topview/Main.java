package com.algorithm.tree.topview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Main {

	static class TreeNode{
		int data;
		TreeNode left,right;
		TreeNode(int data){
			this.data=data;
			this.left=this.right=null;
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
		if(root==null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(root, 0));
		Map<Integer,TreeNode> map = new TreeMap<>();
		
		while(!queue.isEmpty()) {
			Node node= queue.poll();
			if (!map.containsKey(node.distance)) {
				map.put(node.distance, node.node);
            }
	
			if(node.node.left!=null) {
				queue.add(new Node(node.node.left,node.distance-1));
			}
			if(node.node.right!=null) {
				queue.add(new Node(node.node.right,node.distance+1));
			}
		}
		
		 for (Map.Entry<Integer, TreeNode> entry :
             map.entrySet()) {
            System.out.print(entry.getValue().data+" ");
        }
	}
	
	public static void main(String []args) {
		TreeNode root = new TreeNode(20);
		 root.left = new TreeNode(8);
	        root.right = new TreeNode(22);
	        root.left.left = new TreeNode(5);
	        root.left.right = new TreeNode(3);
	        root.right.left = new TreeNode(4);
	        root.right.right = new TreeNode(25);
	        root.left.right.left = new TreeNode(10);
	        root.left.right.right = new TreeNode(14);;
		levelOrderTraversal(root);
	}
}
