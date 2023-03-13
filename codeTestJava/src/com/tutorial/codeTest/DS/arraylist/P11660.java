package com.tutorial.codeTest.DS.arraylist;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//2���� ������
public class P11660 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //1��: �迭(ǥ)�� ũ�� N �Է�
		int query = Integer.parseInt(st.nextToken()); //1��: ���� �� query �Է�
		int i, j;
		
		//2��~: ���� �迭 A �Է�
		int A[][] = new int[N+1][N+1];
		for(i = 1; i <= N; i++) { //��
			st = new StringTokenizer(br.readLine());	
			for(j = 1; j <= N; j++)  //��
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//�� �迭 D ����
		int D[][] = new int[N+1][N+1];
		for(i = 1; i <= N; i++)  //��	
			for(j = 1; j <= N; j++)  //��
				D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j];
		
		//���� query�� ��: (x1,y1) ~ (x2,y2) �Է�
		//���� �� ��� 
		for (i = 0; i < query; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
			System.out.println(result);
		}
		
		

	}

}
