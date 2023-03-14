package com.tutorial.codeTest.DS.투포인터;

import java.io.IOException;
import java.util.Scanner;

//연속된 자연수의 합 구하기
public class P2018 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1;
		int sum = 1;
		int start = 1;
		int end = 1;
		
		while(end < N) {
			if(sum > N)
				sum -= start++;
			else if(sum < N)
				sum += ++end;
			else {
				sum += ++end;
				++count;
			}
		}
		System.out.println(count);
	}
}
