package com.tutorial.codeTest.DS.슬라이딩윈도우;

import java.io.*;
import java.util.*;

//DNA 비밀번호
public class P12891 {
	static int secret[]; //비밀번호 체크 배열
	static int current[]; //현재 상태 배열
	static int check = 0; //ACGT 중 유효성을 만족하는 개수(4이면 유효함)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int length = Integer.parseInt(st.nextToken()); //문자열 길이
		int partial = Integer.parseInt(st.nextToken()); //부분 문자열 길이
		int count = 0; //유효 비밀번호의 개수
		
		char[] arr = new char[length]; //입력 문자 배열
		secret = new int[4];
		current = new int[4];
				
		arr = br.readLine().toCharArray();
		st =  new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			secret[i] = Integer.parseInt(st.nextToken()); //ACGT 최소 개수 입력
			if(secret[i] == 0) //최소개수가 0이면 이미 만족한 것이므로 이에 대해 check++
				check++;
		}
		
		//초기 윈도우
		for(int i = 0; i < partial; i++) 
			add(arr[i]);
		if(check == 4)
			count++;
		
		//슬라이딩 윈도우
		for(int i = partial; i < length; i++) { //초기 윈도우에 대해 슬라이딩하므로 i는 partial~length-1까지 add
			int j = i - partial;				//j는 0~length-1-partial까지 remove
			remove(arr[j]);
			add(arr[i]);
			if(check == 4)
				count++;
		}
		
		System.out.println(count);
		br.close();
	}
	
	public static void add(char c) {
		switch(c) {
		case 'A':
			if(++current[0] == secret[0])
				check++;
			break;
		case 'C':
			if(++current[1] == secret[1])
				check++;
			break;
		case 'G':
			if(++current[2] == secret[2])
				check++;
			break;
		case 'T':
			if(++current[3] == secret[3])
				check++;
			break;
		}
	}
	public static void remove(char c) {
		switch(c) {
		case 'A':
			if(current[0]-- == secret[0])
				check--;
			break;
		case 'C':
			if(current[1]-- == secret[1])
				check--;
			break;
		case 'G':
			if(current[2]-- == secret[2])
				check--;
			break;
		case 'T':
			if(current[3]-- == secret[3])
				check--;
			break;
		}
	}

}
