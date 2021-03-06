package com.algorithm.graph.bfs;

import java.util.LinkedList;

public class Main {

	static class Graph{
		int v;
		LinkedList<Integer> []adj;
		
		Graph(int v){
			this.v=v;
			adj = new LinkedList[v];
	        for (int i=0; i<v; ++i)
	            adj[i] = new LinkedList<>();
		}
		
		void addEdge(int v, int w){
			adj[v].add(w);
		}
	}
	
	static void bfs(Graph graph,int s) {
		boolean []visited = new boolean[graph.v];
		LinkedList<Integer> queue = new LinkedList<>();
		visited[s]=true;
		queue.add(s);
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node+" ");
			for(int i:graph.adj[node]) {
				if(!visited[i]) {
					queue.add(i);
					visited[i]=true;
				}
			}
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
        bfs(g,2);
	}
}
