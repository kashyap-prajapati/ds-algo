package com.algorithm.dp.mincoins;

public class Main {
	
	public static void main(String []args) {
		int []coins= {3,4,5,2,1};
		int value=7;
		System.out.println(minCoins(coins, value, coins.length));
	}
	static int minimum(int m,int n) {
		if(m>n)
			return n;
		return m;
	}
	
	static int minCoins(int []coins,int value, int n) {
		if(value==0) {
			return 0;
		}
		int count = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if(coins[i]<=value) {
				int result = minCoins(coins, value-coins[i], n);
				if(result!=Integer.MAX_VALUE && result + 1< count)
					count=result+1;
			}
		}
		return count;
	}
	

}
