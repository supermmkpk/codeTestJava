package com.tutorial.codeTest.DS.정렬;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//내림차순 정렬(selection sort): O(n^2)
public class P1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char input[] = br.readLine().toCharArray();
		int[] arr = new int[input.length];
		for(int i = 0; i < input.length; i++) 
			arr[i] = Integer.valueOf(input[i]-'0');
		
		//selection sort(내림차순)
		for(int i = 0; i < arr.length; i++) {
			int max = i;
			for(int j = i + 1; j < arr.length; j++) //정렬되지 않은 구간 내 최댓값 구하기
				if(arr[max] < arr[j])
					max = j;
			//앞의 요소와 swap
			if(arr[i] < arr[max]) {
				int tmp = arr[i];
				arr[i] = arr[max];
				arr[max] = tmp;
			}
		}
		for(int e : arr)
			System.out.print(e);
		br.close();
	}
	
}


/*
import java.util.*;

public class P1427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		Integer[] arr = new Integer[input.length()];
		for(int i = 0; i < input.length(); i++) 
			arr[i] = Integer.parseInt(input.substring(i,i+1));
		
		//Arrays.sort(arr, Collections.reverseOrder());
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2-i1; //내림차순
			}
		});
		
		for(int e : arr)
			System.out.print(e);
	}
}
*/
