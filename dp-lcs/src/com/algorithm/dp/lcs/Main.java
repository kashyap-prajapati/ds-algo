package com.algorithm.dp.lcs;

public class Main {
	static int max(int a,int b) {
		if(a>b) {
			return a;
		}else {
			return b;
		}
	}

	static int lcs(char[] p,char[] q,int i,int j) {
		if(i==0 || j==0) {
			return 0;
		}
		if(p[i-1]==q[j-1]) {
			return 1+lcs(p, q, i-1, j-1);
		}else {
			return max(lcs(p,q,i-1,j), lcs(p,q,i,j-1));
		}
	}
	
	static int dpLCS(char[] p,char[] q, int i,int j) {
		int [][]lcs = new int[i+1][j+1];
		
		for(int m=0;m<=i;m++) {
			for(int n=0;n<=j;n++) {
				if(m==0 || n==0) {
					lcs[m][n]=0;
				}
				else if(p[m-1]==q[n-1]) {
					lcs[m][n] = 1 +lcs[m-1][n-1];
				}
				else {
					lcs[m][n] = max(lcs[m][n-1],lcs[m-1][n]);
				}
			}
		}
		
		return lcs[i][j];
	}
	
	public static void main(String []args) {
		 String s1 = "AGGTAB";
	        String s2 = "GXTXAYB";
		System.out.println(lcs(s1.toCharArray(), s2.toCharArray(), s1.length(),s2.length()));
	System.out.println(dpLCS(s1.toCharArray(), s2.toCharArray(), s1.length(),s2.length()));

	}
}
