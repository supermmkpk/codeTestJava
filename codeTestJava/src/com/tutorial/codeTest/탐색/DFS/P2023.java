package com.tutorial.codeTest.Ž��.DFS;

import java.util.Scanner;

//�ű��� �Ҽ� ã�� (using DFS)
public class P2023 {
	
	static int N; //�ڸ��� N
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}
	
	static void DFS(int num, int magnitude) {
		//���� ���� 
		if(magnitude == N) { 
			if(prime(num)) 
				System.out.println(num);
			return;
		}
		
		for(int i = 1; i < 10; i += 2) 
			if(prime(10 * num + i))
				DFS(10 * num + i, magnitude + 1); 
				//DFS(10 * num + i, ++magnitude) �ϸ� magnitude ���� ������ ���̱� ������ magnitude==N�� �����ϱ� ���� ����Լ��� ����ȴ�.
	}
	
	static boolean prime(int num) {
		for(int i = 2; i <= num / 2; i++) 
			if(num % i == 0)
				return false;
		
		return true;
	}
	
}