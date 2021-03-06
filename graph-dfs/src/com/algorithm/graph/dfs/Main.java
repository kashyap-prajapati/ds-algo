package com.algorithm.graph.dfs;

import java.util.LinkedList;

public class Main {
	
	static class Graph{
		int v;
		LinkedList<Integer> []adj ;
		Graph(int v){
			this.v=v;
			adj = new LinkedList[v];
			for(int i=0;i<v;i++)
				adj[i]=new LinkedList<Integer>();
		}
		void addEdge(int v,int w){
			adj[v].add(w);
		}
	}
	
	
	static void dfs(Graph g,int s,boolean []visited) {
		visited[s]=true;
		System.out.print(" "+s);
		for(Integer i:g.adj[s]) {
			if(!visited[i])
				dfs(g, i, visited);
		}
	}
	
	
	public static void main(String []args) {
		Graph g = new Graph(4); 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        boolean []visited = new boolean[4];
		dfs(g, 2, visited);
	}
}
