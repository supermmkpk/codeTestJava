package com.tutorial.codeTest.DS.arraylist;

import java.io.*;
import java.util.*;

public class P11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int query = Integer.valueOf(stringTokenizer.nextToken());
		
		long[] S = new long[N+1];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for(int i = 1; i <= N; i++)
			S[i] = S[i-1] + Long.parseLong(stringTokenizer.nextToken()); //합 배열 만들기: S[0]=0이어야...
		
		for(int i = 0; i< query; i++) { //구간합 구하기
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int left = Integer.parseInt(stringTokenizer.nextToken()); //left번째 수
			int right = Integer.parseInt(stringTokenizer.nextToken()); //right번째 수
			System.out.println(S[right] - S[left-1]);
		}

	}
}
