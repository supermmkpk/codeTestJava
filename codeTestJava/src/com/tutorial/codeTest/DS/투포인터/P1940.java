package com.tutorial.codeTest.DS.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//주몽의 명령
public class P1940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] serial = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			serial[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(serial);
		int i = 0;
		int j = serial.length - 1;
		int count = 0;
		while(i < j) {
			if(serial[i] + serial[j] < M) 
				++i;
			else if(serial[i] + serial[j] > M)
				--j;
			else {
				++count;
				++i;
				--j;
			}
		}
		
		System.out.println(count);
		br.close();
	}

}
