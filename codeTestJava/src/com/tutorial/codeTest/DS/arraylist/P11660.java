package com.tutorial.codeTest.DS.arraylist;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//2차원 구간합
public class P11660 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //1줄: 배열(표)의 크기 N 입력
		int query = Integer.parseInt(st.nextToken()); //1줄: 질의 수 query 입력
		int i, j;
		
		//2줄~: 원본 배열 A 입력
		int A[][] = new int[N+1][N+1];
		for(i = 1; i <= N; i++) { //행
			st = new StringTokenizer(br.readLine());	
			for(j = 1; j <= N; j++)  //열
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//합 배열 D 생성
		int D[][] = new int[N+1][N+1];
		for(i = 1; i <= N; i++)  //행	
			for(j = 1; j <= N; j++)  //열
				D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j];
		
		//다음 query개 줄: (x1,y1) ~ (x2,y2) 입력
		//구간 합 출력 
		for (i = 0; i < query; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
			System.out.println(result);
		}
		
		

	}

}
