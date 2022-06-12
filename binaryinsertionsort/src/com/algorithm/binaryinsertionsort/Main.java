package com.algorithm.binaryinsertionsort;

public class Main {
	
	static void floydwarshall(int [][] graph,int noOfVertex) {
		int [][]matrix=new int[noOfVertex][noOfVertex];
		for(int i=0;i<noOfVertex;i++)
			for(int j=0;j<noOfVertex;j++)
				matrix[i][j] = graph[i][j];
		
		for (int k = 0; k < noOfVertex; k++) {
	      for (int i = 0; i < noOfVertex; i++) {
	        for (int j = 0; j < noOfVertex; j++) {
	          if (matrix[i][k] + matrix[k][j] < matrix[i][j])
	            matrix[i][j] = matrix[i][k] + matrix[k][j];
	        }
	      }
		}

	}
	
	public static void main(String []args) {
		
	}

}
