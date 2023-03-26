package com.tutorial.codeTest.정렬.quick;

import java.io.*;
import java.util.*;

public class P11004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //데이터 개수
		int K = Integer.parseInt(st.nextToken()); //K 번째 수
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		quickSort(arr, 0, N-1, K-1);
		System.out.println(arr[K-1]);

		br.close();
	}
	
	public static void quickSort(int[] A, int start, int end, int K) {
		if(start < end) {
			int pivot = partition(A, start, end);
			if(K == pivot)
				return;
			else if(K < pivot)
				quickSort(A, start, pivot - 1, K);
			else
				quickSort(A, pivot + 1, end, K);
		}
	}
	
	public static int partition(int[] A, int start, int end) {
		if(start + 1 == end) {
			if(A[start] > A[end])
				swap(A, start, end);
			return end;
		}
		int mid = start + end / 2;
		swap(A, start, mid);
		int pivot = A[start];
		int i = start + 1;
		int j = end;
		while(i <= j) { 
			while(A[i] < pivot && i < A.length - 1)
				i++;
			while(A[j] > pivot && j > 0 )
				j--;
			if(i <=j)
				swap(A, i++,j--);
		}
		A[start] = A[j];
		A[j] = pivot;
		return j;		
	}
	
	public static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp; 
	}

}
