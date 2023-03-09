package com.tutorial.codeTest.complexity;

public class TimeComplexity {

	public static void main(String[] args) {
		//1~100 사이 값 랜덤 선택
		int findNum = (int)(Math.random() *100);
		for(int i = 0; i < 100; i++) { //O(n) = N, 세타(n) = N/2, 오메가(n) = 1
			if(i == findNum) {
				System.out.println(i);
				break;
			}
		}

	}

}
