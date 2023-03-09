package com.tutorial.codeTest.complexity.evaluation;

public class Evaluation1 {
	
	public static void main(String[] args) {
		int N = 100000;
		int cnt = 0;
		for(int i = 0; i < N; i++)
			System.out.println("연산 횟수 : " + cnt++); //상수X, 가장 많이 중첩된 반복문 => O(N)
	}

}
