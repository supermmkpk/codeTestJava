package com.tutorial.codeTest.정렬.merge;

import java.io.*;

//merge sort
public class P2751 {

	public static int[] arr;
	public static int[] tmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); //수의 개수 N
		arr = new int[N];
		tmp = new int[N]; //임시 배열 tmp
		for(int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		mergeSort(0, N - 1);
		for(int e : arr)
			bw.write(Integer.toString(e) + '\n');
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void mergeSort(int start, int end) {
		//종료 조건
		if(end - start < 1)
			return;
		int mid = start + ((end - start) / 2);
		
		mergeSort(start, mid);
		mergeSort(mid + 1, end);
		for(int i = start; i <= end; i++)
			tmp[i] = arr[i];
		int k = start;
		int idx1 = start;
		int idx2 = mid + 1;
		while(idx1 <= mid && idx2 <= end) {
			if(tmp[idx1] < tmp[idx2])
				arr[k++] = tmp[idx1++];
			else
				arr[k++] = tmp[idx2++];
		}
		//나머지
		while(idx1 <= mid)
			arr[k++] = tmp[idx1++];
		while(idx2 <= end)
			arr[k++] = tmp[idx2++];
		
	}

}
