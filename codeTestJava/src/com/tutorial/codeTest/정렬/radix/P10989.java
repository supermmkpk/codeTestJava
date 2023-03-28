package com.tutorial.codeTest.����.radix;

import java.io.*;

//radixSort
public class P10989 {
    public static final int maxMag = 5; //�־����� ���� <= 100000
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		for(int i = 0; i < N; i++)
			A[i] = Integer.parseInt(br.readLine());
		
		//radixSort
		int magnitude = 1; //1�� �ڸ�����
		for(int i = 0; i < maxMag; i++) {
			int[] countSum = new int[10]; //�ڸ��� �� ���� ����
			
			int j;
			for(j = 0; j < A.length; j++)
				++countSum[(A[j] / magnitude) % 10];
			for(j = 1; j < 10; j++) //count�� ����, ��, �չ迭�� ����.
				countSum[j] += countSum[j-1];
			
			int[] tmp = new int[A.length];
			for(j = A.length - 1; j >= 0; j--) {
				//countSum�� �������� ���°�� ��Ÿ���� ������, �ε����δ� 1�� ����� ��.
				tmp[--countSum[(A[j] / magnitude) % 10]] = A[j]; 
			}
			
			for(j = 0; j < A.length; j++)
				A[j] = tmp[j];
			
			magnitude *= 10; 
		}
	
		//���
		for(int e : A)
			bw.write(Integer.toString(e) + '\n');
		bw.flush();
		bw.close();
		br.close();
	}
}