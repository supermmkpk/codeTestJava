package com.tutorial.codeTest.DS.투포인터;

import java.io.*;
import java.util.*;

//좋은 수
public class P1253 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] num = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//for(int i = 0; st.hasMoreTokens(); i++)
		for(int i = 0; i < N; i++)
			num[i] = Long.parseLong(st.nextToken());
		Arrays.sort(num);
		
		int count = 0;
		for(int k = 0; k < N; k++) {
			long check = num[k];
			int i = 0;
			int j =  N - 1;
			while(i < j) {
				if(num[i] + num[j] < check)
					++i;
				else if (num[i] + num[j] > check)
					--j;
				else {
					if(i != k && j != k) {
						++count;
						break;
					}
					else if(i == k)
						++i;
					else if(j == k)
						--j;
				}
			}
		}
		System.out.println(count);
		br.close();
	}
	
}

