package com.tutorial.codeTest.DS.������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



//������ �� ���ϱ�
public class P10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.valueOf(st.nextToken()); //������ ���� N �Է�
		int M = Integer.valueOf(st.nextToken()); //������ �� M
	
		long[] sum = new long[N]; //�չ迭 sum ����
		long[] count = new long[M]; //�ε���(������ ��) ���� ���� ���� ������ ī��Ʈ�ϴ� �迭 count 
		long result = 0;
	
		st = new StringTokenizer(br.readLine());
		sum[0] = Long.valueOf(st.nextToken());
		for(int i = 1; i < N; i++) 
			sum[i] = sum[i-1] + Long.valueOf(st.nextToken()); //S[i] = S[i-1] + A[i]
	
		for(int i = 0; i < N; i++) {
			int remain = (int) (sum[i] % M);
			if(remain == 0) //0~i ����
				result++;
			count[remain]++;
		}
	
		for(int i = 0; i < M; i++) {
			if(count[i] > 1)
				result += count[i] * (count[i]-1) / 2; //count[i] COMBINATION 2
		}
		
		System.out.println(result);
	}
}
