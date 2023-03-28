package com.tutorial.codeTest.정렬.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//버블소트 프로그램_MergeSort
public class P1517 {
	
	public static int[] arr, tmp;
	public static long result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		tmp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		mergeSort(0, N - 1);
		System.out.println(result);
	}
	
	public static void mergeSort(int start, int end) {
		//종료 조건
		if(end - start < 1)
			return;
		
		int mid = start + ((end - start) / 2);
		mergeSort(start, mid);
		mergeSort(mid + 1, end);
		
		for(int i = start; i <= end; i++)
			tmp[i] = arr[i];

		int k = start; //arr에서의 현재 인덱스
		int idx1 = start;
		int idx2 = mid + 1;
		
		while(idx1 <= mid && idx2 <= end) {
			if(tmp[idx1] > tmp[idx2]) {
				result += idx2 - k; //이동거리 = bubbleSort에서의 swap 횟수
				arr[k++] = tmp[idx2++];
			}
			else
				arr[k++] = tmp[idx1++];
		}
		while(idx1 <= mid)
			arr[k++] = tmp[idx1++];
		while(idx2 <= end)
			arr[k++] = tmp[idx2++];
	}

}
