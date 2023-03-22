package com.tutorial.codeTest.DS.정렬;

import java.io.*;
import java.util.Arrays;

//버블 소트 프로그램 
public class P1377 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		mData[] arr = new mData[N];
		for(int i = 0; i < N; i++)
			arr[i] = new mData(i, Integer.parseInt(br.readLine()));
		
		Arrays.sort(arr);
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(max < arr[i].index - i)
				max = arr[i].index - i;
		}
		System.out.println(max + 1);
			
		br.close();
	}

}

class mData implements Comparable<mData> {
	int index;
	int value;
	
	mData(int index, int value) {
		super();
		this.index = index;
		this.value = value;
	}
	
	@Override
	public int compareTo(mData o) { //value 기준 오름차순 정렬
		return this.value - o.value;
		/*
		 * this.value > o.value : +
		 * this.value == o.value : 0
		 * this.value < o.value : -
		 */
	}
}