package com.tutorial.codeTest.정렬.insertion;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//ATM 인출 시간(insertion sort)
public class P11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); //사람 수
		
		int[] time = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) 
			time[i] = Integer.parseInt(st.nextToken()); //인출하는데 걸리는 시간
		
		//삽입 정렬
		for(int i = 1; i < N; i++) {
			int insertIndex = i;
			int insertValue = time[i];
			for(int j = i - 1; j >= 0; j--) { //삽입 위치 탐색
				if(time[j] < insertValue) {
					insertIndex = j + 1;
					break;
				}
				if(j == 0)
					insertIndex = 0;
			}
			
			for(int j = i; j > insertIndex; j--) //오른쪽으로 한칸 shift
				time[j] = time[j-1];
			time[insertIndex] = insertValue; //삽입
		}
		int sum = 0;
		for(int i = N; i >= 1; i--) 
			sum += time[N-i] * i;
		
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
		br.close();
	}
}


/*
import java.util.*;

public class P11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //사람 수
		int[] time = new int[N];
		for(int i = 0; i < N; i++) 
			time[i] = sc.nextInt(); //인출하는데 걸리는 시간
		
		Arrays.sort(time);
		
		int sum = 0;
		for(int i = N; i >= 1; i--) 
			sum += time[N-i] * i;
		
		System.out.println(sum);
	}
}
*/
