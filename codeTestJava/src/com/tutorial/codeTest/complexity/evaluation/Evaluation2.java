package com.tutorial.codeTest.complexity.evaluation;

public class Evaluation2 {
	public static void main(String[] args) {
		int N = 100000;
		int cnt = 0;
		for(int i = 0; i < N; i++)
			System.out.println("���� Ƚ�� : " + cnt++); //���X, ���� ���� ��ø�� �ݺ��� => O(N)
		for(int i = 0; i < N; i++)
			System.out.println("���� Ƚ�� : " + cnt++); 
		for(int i = 0; i < N; i++)
			System.out.println("���� Ƚ�� : " + cnt++);
	}
}
