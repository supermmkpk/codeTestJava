package com.tutorial.codeTest.����.insertion;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//ATM ���� �ð�(insertion sort)
public class P11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); //��� ��
		
		int[] time = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) 
			time[i] = Integer.parseInt(st.nextToken()); //�����ϴµ� �ɸ��� �ð�
		
		//���� ����
		for(int i = 1; i < N; i++) {
			int insertIndex = i;
			int insertValue = time[i];
			for(int j = i - 1; j >= 0; j--) { //���� ��ġ Ž��
				if(time[j] < insertValue) {
					insertIndex = j + 1;
					break;
				}
				if(j == 0)
					insertIndex = 0;
			}
			
			for(int j = i; j > insertIndex; j--) //���������� ��ĭ shift
				time[j] = time[j-1];
			time[insertIndex] = insertValue; //����
		}
		int sum = 0;
		for(int i = N; i >= 1; i--) 
			sum += time[N-i] * i;
		
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
		br.close();
	}
}


/*
import java.util.*;

public class P11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //��� ��
		int[] time = new int[N];
		for(int i = 0; i < N; i++) 
			time[i] = sc.nextInt(); //�����ϴµ� �ɸ��� �ð�
		
		Arrays.sort(time);
		
		int sum = 0;
		for(int i = N; i >= 1; i--) 
			sum += time[N-i] * i;
		
		System.out.println(sum);
	}
}
*/
