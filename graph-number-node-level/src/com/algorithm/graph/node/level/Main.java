package com.algorithm.graph.node.level;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Graph {
		int V;
		LinkedList<Integer> []adj;
		Graph(int v){
			this.V=v;
			this.adj= new LinkedList[v];
			for(int i=0;i<v;i++) {
				this.adj[i]=new LinkedList<>();
			}
		}
		
		void addEdge(int v, int w){
			adj[v].add(w);
		}
	}
	
	static int countNumderOfNodeAtLevel(Graph graph,int s, int l) {
		boolean []visited = new boolean[graph.V];
		int []level = new int[graph.V];
		visited[s]=true;
		level[s]=0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		while(!queue.isEmpty()) {
			int node = queue.poll();
			for(int i:graph.adj[node]) {
				if(!visited[i]) {
					visited[i]=true;
					level[i]=level[node]+1;
					queue.add(i);
				}
			}
		}
		int count=0;
		for(int i=0;i<graph.V;i++) {
			if(level[i]==l)
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
	
		  Graph g = new Graph(6);
		    g.addEdge(0, 1);
		    g.addEdge(0, 2);
		    g.addEdge(1, 3);
		    g.addEdge(2, 4);
		    g.addEdge(2, 5);
		  System.out.println(countNumderOfNodeAtLevel(g, 0, 2));
		    
	}

}
