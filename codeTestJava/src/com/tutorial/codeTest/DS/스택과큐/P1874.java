package com.tutorial.codeTest.DS.���ð�ť;

import java.io.*;
import java.util.*;

//�������� �������� ���� �����
public class P1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine()); //������ ����
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		boolean isNo = false;
		
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(num <= input) { //up
				while(num <= input) {
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			}
			else { //num>input: down
				int pop = stack.pop();
				if(input < pop) {
					System.out.println("NO");
					isNo = true;
					break;
				}
				else
					sb.append("-\n");
			}
		}
		
		if(isNo == false)
			System.out.println(sb.toString());

		br.close();
	}
}
