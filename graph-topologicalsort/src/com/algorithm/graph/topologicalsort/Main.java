package com.algorithm.graph.topologicalsort;

import java.util.LinkedList;
import java.util.Stack;

public class Main {

	
	static class Graph {
		int v;
		LinkedList<Integer> []adj;
		Graph(int v){
			this.v=v;
			this.adj = new LinkedList[v];
			for(int i=0;i<v;i++) {
				this.adj[i]=new LinkedList<Integer>();
			}
		}
		
		void addEdge(int v,int w){
			this.adj[v].add(w);
		}
	}
	
	static void dfs(Graph g,boolean []visited,int s,Stack<Integer> stack) {
		visited[s]=true;
		for(int i:g.adj[s]) {
			if(!visited[i])
				dfs(g, visited, i,stack);
		}
		stack.push(s);
	}
	
	static void topologicalSort(Graph g) {
		boolean []visited = new boolean[g.v];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<g.v;i++)
			if(!visited[i])
				dfs(g, visited, i,stack);
		
		while(!stack.isEmpty())
			System.out.print(" "+stack.pop());
	}
	
	/**
	 *   0--------->2 
	 *   |         |
	 *   |         |
 *       3<---------1
	 */
	
	public static void main(String []args) {
		Graph g =  new Graph(6);
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
		
		topologicalSort(g);
	}
}
