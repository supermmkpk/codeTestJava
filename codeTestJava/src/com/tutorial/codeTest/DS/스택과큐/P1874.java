package com.tutorial.codeTest.DS.스택과큐;

import java.io.*;
import java.util.*;

//스택으로 오름차순 수열 만들기
public class P1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine()); //수열의 개수
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
