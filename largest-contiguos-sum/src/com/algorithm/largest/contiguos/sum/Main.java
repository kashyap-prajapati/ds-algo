package com.algorithm.largest.contiguos.sum;

public class Main {

	static int maxSubArraySum(int a[]) {
		int far=Integer.MIN_VALUE;
		int end=0;
		
		for(int i=0;i<a.length;i++) {
			end = end + a[i];
			if(far<end)
				far=end;
			if(end<0)
				end=0;
		}
		return far;
	}

	public static void main(String []args) {
		 int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
	        System.out.println("Maximum contiguous sum is " +
	                                       maxSubArraySum(a));
	}
}
