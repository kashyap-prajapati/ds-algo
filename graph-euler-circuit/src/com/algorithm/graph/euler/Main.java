package com.algorithm.graph.euler;

import java.util.LinkedList;
import java.util.List;

public class Main {
	static class Graph{
		int V;
		List<Integer> []adj;
		int []inDegree;
		
		Graph(int v){
			this.V=v;
			adj = new LinkedList[V];
			inDegree = new int[V];
			for(int i=0;i<V;i++) {
				adj[i]=new LinkedList<Integer>();
				inDegree[i]=0;
			}
		}
		void addEdge(int v,int w){
			adj[v].add(w);
			inDegree[w]++;
		}
		
		void dfs(Graph graph,int v,boolean []visited) {
			visited[v]=true;
			for(int i:graph.adj[v]) {
				if(!visited[i])
					dfs(graph, i, visited);
			}
		}
		
		Graph getTranspose(Graph graph) {
			Graph trasponseGraph = new Graph(graph.V);
			for(int v=0; v<graph.V;v++) {
				for(int w:graph.adj[v]) {
					trasponseGraph.adj[w].add(v);
					trasponseGraph.inDegree[v]++;
				}
			}
			return trasponseGraph;
		}
		
		
		boolean isStronglyConnectedComponent(Graph graph) {
			boolean []visited = new boolean[graph.V];
			
			dfs(graph, 0, visited);
			
			for(int i=0;i<visited.length;i++)
				if(!visited[i])
					return false;
			
			Graph graphTranspose = getTranspose(graph);
		
			for(int i=0;i<visited.length;i++)
				visited[i]=false;
			
			dfs(graphTranspose, 0, visited);
			
			for(int i=0;i<visited.length;i++)
				if(!visited[i])
					return false;
			
			return true;
		}
		
		boolean isEulerCyclePresent(Graph graph) {
			if(!isStronglyConnectedComponent(graph))
				return false;
			for(int i=0;i<graph.V;i++) {
				if(graph.adj[i].size()!=graph.inDegree[i]) {
					return false;
				}
			}
			return true;
		}
		
		
		public static void main(String []args) {
			 Graph g = new Graph(5);
		        g.addEdge(1, 0);
		        g.addEdge(0, 2);
		        g.addEdge(2, 1);
		        g.addEdge(0, 3);
		        g.addEdge(3, 4);
		        g.addEdge(4, 0);
		 
		        if (g.isEulerCyclePresent(g))
		            System.out.println("euler circuit is present ");
		        else
		            System.out.println("euler circuit is not present ");
		}
	}

}
