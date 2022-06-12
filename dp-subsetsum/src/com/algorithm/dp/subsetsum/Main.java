package com.algorithm.dp.subsetsum;

public class Main {
	
	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum =9;
        int n = set.length;
        
        System.out.println(isSubsetPresent(set, sum, n));
        System.out.println(dynamicSubsetPresent(set, sum, n));
	}

	static boolean isSubsetPresent(int []set,int sum,int n) {
		if(sum==0) {
			return true;
		}
		
		if(n==0) {
			return false;
		}
		
		if(set[n-1]>sum) {
			return isSubsetPresent(set, sum, n-1);
		}
		else{
			return isSubsetPresent(set, sum-set[n-1], n-1) ||  isSubsetPresent(set, sum, n-1);
		}
	}
	
	static boolean dynamicSubsetPresent(int []set,int sum,int n) {
		boolean[][] k =  new boolean[n+1][sum+1];
		
		for(int i=0;i<=n;i++) {
			k[i][0]=true;
		}
		
		for(int i=1;i<=sum;i++) {
			k[0][i]=false;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				if(j>=set[i-1]) {
					k[i][j]=k[i-1][j] || k[i-1][j-set[i-1]];
				}else {
					k[i][j]=k[i-1][j];
				}
			}
		}
		
		return k[n][sum];
	}
}
