package com.tutorial.codeTest.DS.��������;

import java.io.IOException;
import java.util.Scanner;

//���ӵ� �ڿ����� �� ���ϱ�
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
