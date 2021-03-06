package com.dc.quick.sort;

public class Main {
	static int partion(int []arr,int l,int r) {
		int pivot = arr[r];
		int i=l-1;
		for(int j=l;j<r;j++) {
			if(arr[j]<=pivot) {
				i++;
				int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1; 
	}
	
	
	static void quickSort(int []arr,int l,int r) {
		if(l<r) {
			int pivot = partion(arr, l, r);
			quickSort(arr, l, pivot-1);
			quickSort(arr, pivot+1, r);
		}
	}
	
	static void print(int []arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(" "+arr[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int arr[] = {2,6,3,4};
		quickSort(arr, 0,arr.length-1);
		print(arr);
	}

}
