package com.algorithms.gd.prims;

public class Main {

	static void prims(int [][]graph,int noOfVertex) {
		boolean[] visited = new boolean[noOfVertex];
	
		
		int noOfEdges = 0;
		visited[0] = true;
		while(noOfEdges < noOfVertex-1) {
			int x=0;
			int y=0;
			int min=Integer.MAX_VALUE;
			for(int i=0;i<noOfVertex;i++) {
				if(visited[i]) {
					for(int j=0;j<noOfVertex;j++) {
						if(!visited[j] && graph[i][j]!=0 &&  i!=j) {
							if(min>graph[i][j]) {
								min=graph[i][j];
								x=i;
								y=j;
							}
						}
					}
				}
				
			}
			System.out.println(x + " - " + y + " :  " + graph[x][y]);
			visited[y] = true;
		    noOfEdges++;
		}
	}
	public static void main(String []args) {
		int v=5;  
		int[][] G = { { 0, 9, 75, 0, 0 },
					  { 9, 0, 95, 19, 42 }, 
					  { 75, 95, 0, 51, 66 }, 
					  { 0, 19, 51, 0, 31 },
			          { 0, 42, 66, 31, 0 } };
		 
		prims(G, v);
	}
}
