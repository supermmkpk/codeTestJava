package com.tutorial.codeTest.DS.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



//나머지 합 구하기
public class P10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.valueOf(st.nextToken()); //수열의 개수 N 입력
		int M = Integer.valueOf(st.nextToken()); //나누는 수 M
	
		long[] sum = new long[N]; //합배열 sum 생성
		long[] count = new long[M]; //인덱스(나머지 값) 별로 같은 값의 개수를 카운트하는 배열 count 
		long result = 0;
	
		st = new StringTokenizer(br.readLine());
		sum[0] = Long.valueOf(st.nextToken());
		for(int i = 1; i < N; i++) 
			sum[i] = sum[i-1] + Long.valueOf(st.nextToken()); //S[i] = S[i-1] + A[i]
	
		for(int i = 0; i < N; i++) {
			int remain = (int) (sum[i] % M);
			if(remain == 0) //0~i 구간
				result++;
			count[remain]++;
		}
	
		for(int i = 0; i < M; i++) {
			if(count[i] > 1)
				result += count[i] * (count[i]-1) / 2; //count[i] COMBINATION 2
		}
		
		System.out.println(result);
	}
}
