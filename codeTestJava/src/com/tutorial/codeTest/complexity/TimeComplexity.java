package com.tutorial.codeTest.complexity;

public class TimeComplexity {

	public static void main(String[] args) {
		//1~100 ���� �� ���� ����
		int findNum = (int)(Math.random() *100);
		for(int i = 0; i < 100; i++) { //O(n) = N, ��Ÿ(n) = N/2, ���ް�(n) = 1
			if(i == findNum) {
				System.out.println(i);
				break;
			}
		}

	}

}
