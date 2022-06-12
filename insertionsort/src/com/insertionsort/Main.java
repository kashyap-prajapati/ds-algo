package com.insertionsort;

public class Main {
	

	static void print(int []arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(" "+arr[i]);
		}
		System.out.println();
	}

	public static void main(String []args) {
		int arr[] = {10,2,1,4,2};
		for(int i=0;i<arr.length;i++) {
			for(int j=i; j>0 && arr[j-1]>arr[j]; j--) {
				int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
			}
		}
		print(arr);
	}
}
