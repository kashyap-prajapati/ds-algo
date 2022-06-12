package com.algorithm.dp.knapsack;

public class Main {

	public static void main(String[] args) {
		int []weight  = {10,20,30,40};
		int []value  = {60,100,120,10};
		int capacity = 50;
		System.out.println(knapsack(value, weight, 3, capacity));
		System.out.println(dynamincknapsack(value, weight, 3, capacity));
	}
	
	static int maximum(int m, int n) {
		if(m>n)
			return m;
		return n;
	}
	
	static int knapsack(int []value,int []weight,int n,int capacity) {
		if(n==0 ||  capacity==0) {
			return 0;
		}
		if(weight[n-1]>capacity) {
			return knapsack(value, weight, n-1, capacity);
		}else {
			return maximum(value[n-1]+knapsack(value, weight, n-1, capacity-weight[n-1]), 
						knapsack(value, weight, n-1, capacity));
		}
	}
	
	static int dynamincknapsack(int []value,int []weight,int n,int capacity) {
		int i;
		int j;
		int [][]k = new int[n+1][capacity+1];
		
		for(i=0;i<=n;i++) {
			for(j=0;j<=capacity;j++) {
				if(i==0 || j==0) {
					k[i][j]=0;
				}
				else if(weight[i-1]<=j) {
					k[i][j]=maximum(value[i-1]+ k[i-1][j-weight[i-1]], k[i-1][j]);
				}else {
					k[i][j]=k[i-1][j];
				}
			}
		}
		
		
		return k[n][capacity];
	}

}
