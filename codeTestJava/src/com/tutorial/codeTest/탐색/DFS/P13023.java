package com.tutorial.codeTest.Ž��.DFS;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class P13023 {
	static ArrayList<Integer>[] edge;
	static boolean[] visited;
	static boolean arrived; //��� ���̰� 5�̻����� �����ߴ°�?
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //����� ��(��� ����) N
		int edgeNum = Integer.parseInt(st.nextToken()); //������ ��(���� ����) edgeNum
		
		edge = new ArrayList[N];
		for(int i = 0; i < N; i++)
			edge[i] = new ArrayList<Integer>(); //��������Ʈ edge �ʱ�ȭ
		visited = new boolean[N];
		arrived = false;
		
		for(int i = 0; i < edgeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			edge[left].add(right); //ģ�������̹Ƿ� ������ ����
			edge[right].add(left);
		}
		
		for(int i = 0; i < N; i++) { //�� ��忡 ���Ͽ� DFS
			DFS(i, 1);
			if(arrived)
				break;
		}
		System.out.println((arrived) ? "1" : "0");
		
		br.close();
	}
	
	static void DFS(int now, int depth) {
		//��������: ��� ���̰� 5 ���� || arrived == true)
		if(depth >= 5 || arrived) {
			arrived = true;
			return;
		}
			
		visited[now] = true;
		for(int e : edge[now])
			if(!visited[e])
				DFS(e, depth + 1);
		
		visited[now] = false;
	}
	
}
