package com.tutorial.codeTest.Ž��.binarysearch;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

//���ϴ� ���� ã��
public class P1920 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); //������ ������ ���� N
		int[] num = new int[N]; 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num); //����Ž�� ��� -> ����
		
		int M = Integer.parseInt(br.readLine()); //Ž���� ������ ���� M
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken()); //ã�� ���� target
			int start = 0;
			int end = num.length - 1;
			
			boolean found = false;
			while(start <= end) {
				int midIdx = (start + end) / 2;
				int midVal = num[midIdx];
				if(midVal > target)
					end = midIdx - 1;
				else if(midVal < target)
					start = midIdx + 1;
				else { //midVal == target 
					found = true;
					break;
				}
			}
			bw.write((found) ? "1\n" : "0\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
