package com.tutorial.codeTest.탐색.DFS;

import java.util.Scanner;

//신기한 소수 찾기 (using DFS)
public class P2023 {
	
	static int N; //자릿수 N
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}
	
	static void DFS(int num, int magnitude) {
		//종료 조건 
		if(magnitude == N) { 
			if(prime(num)) 
				System.out.println(num);
			return;
		}
		
		for(int i = 1; i < 10; i += 2) 
			if(prime(10 * num + i))
				DFS(10 * num + i, magnitude + 1); 
				//DFS(10 * num + i, ++magnitude) 하면 magnitude 값을 만지는 것이기 때문에 magnitude==N에 도달하기 전에 재귀함수가 종료된다.
	}
	
	static boolean prime(int num) {
		for(int i = 2; i <= num / 2; i++) 
			if(num % i == 0)
				return false;
		
		return true;
	}
	
}