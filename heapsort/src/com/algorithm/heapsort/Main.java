package com.algorithm.heapsort;

public class Main {

	static void print(int []arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(" "+arr[i]);
		}
		System.out.println();
	}
	
	static void swap(int []a, int i , int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	static void maxHeapSort(int []arr,int n) {
		for(int i=n/2-1;i>=0;i--)
			maxHeapify(arr, i, n);
		for(int i=n-1;i>=0;i--) {
			swap(arr, 0, i);
			maxHeapify(arr, 0, i);
		}
	}
	static void minHeapSort(int []arr,int n) {
		for(int i=n/2-1;i>=0;i--)
			minHeapify(arr, i, n);
		for(int i=n-1;i>=0;i--) {
			swap(arr, 0, i);
			minHeapify(arr, 0,i);
		}
	}
	
	static void maxHeapify(int []arr, int i, int n) {
		int largest=i;
		int left=2*i+1;
		int right=2*i+2;
		
		if(left<n && arr[left]>arr[largest])
			largest=left;
		if(right<n && arr[right]>arr[largest])
			largest=right;
		
		if(largest!=i) {
			swap(arr, i, largest);
			maxHeapify(arr,largest,n);
		}
	}
	static void minHeapify(int []arr,int i,int n) {
		int smallest=i;
		int left=2*i+1;
		int right=2*i+2;
		if(left<n && arr[left]<arr[smallest]) 
			smallest=left;
		if(right<n && arr[right]<arr[smallest])
			smallest=right;
		if(smallest!=i) {
			swap(arr, i, smallest);
			minHeapify(arr, smallest, n);
		}
	}
	
	
	public static void main(String []args) {
		int []a = {9,2,5,1,22};
		minHeapSort(a, a.length);
		print(a);
		
	}
}
