package com.algorithm.graph.possible.path;

import java.util.LinkedList;

public class Main {

	static class Graph{
		int v;
		LinkedList<Integer> []adj;
		Graph(int v){
			this.v=v;
			this.adj = new LinkedList[v];
			for(int i=0;i<v;i++) {
				adj[i] = new LinkedList<>();	
			}
		}
		void addEdge(int v, int w)
	    {
	        adj[v].add(w);
	    }
	}
	
	static int pathCount(Graph g,int u,int v,int count) {
		if(u==v) {
			count++;
		}else {
			for(int i:g.adj[u]) {
				count = pathCount(g, i, v, count);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		 Graph g = new Graph(5);
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(0, 3);
	        g.addEdge(1, 3);
	        g.addEdge(2, 3);
	        g.addEdge(1, 4);
	        g.addEdge(2, 4);
	 
	        int s = 0, d = 3;
	        System.out.println(pathCount(g,s, d,0));
	}
}
