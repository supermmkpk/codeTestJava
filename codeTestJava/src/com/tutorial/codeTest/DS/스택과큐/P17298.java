package com.tutorial.codeTest.DS.���ð�ť;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Stack;


//��ū�� ���ϱ�
public class P17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); //������ ũ�� N
		int[] seq = new int[N];  //���� �迭
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			seq[i] = Integer.parseInt(st.nextToken());
		
		int[] result = new int[N];
		Stack<Integer> stack = new Stack<>();
		stack.push(0); //���� �ʱ�ȭ
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && seq[i] > seq[stack.peek()]) 
				result[stack.pop()] = seq[i];
			stack.push(i);
		}
		while(!stack.isEmpty())
			result[stack.pop()] = -1;
		
		for(int e : result)
			bw.write(e + " ");
		bw.newLine();
		
		bw.flush();
		br.close();
		bw.close();
	}

}
