package com.tutorial.codeTest.Ž��.BFS;

import java.io.*;
import java.util.*;

//DFS�� BFS 
public class P1260 {
	static ArrayList<Integer>[] edge;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //��� ����
		int M = Integer.parseInt(st.nextToken()); //���� ����
		int init = Integer.parseInt(st.nextToken()); //���� ��� ��ȣ
		
		edge = new ArrayList[N + 1];
		for(int i = 1; i < N + 1; i++) 
			edge[i] = new ArrayList<Integer>(); //���� ����Ʈ �ʱ�ȭ
		for(int i = 0; i < M; i++) { //���� �Է�
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			edge[left].add(right); //���� ����
			edge[right].add(left);
		}
		for(int i = 1; i < N + 1; i++) 
			Collections.sort(edge[i]); //��������Ʈ ����
		
		visited = new boolean[N + 1];
		DFS(init);
		System.out.println();
		
		visited = new boolean[N + 1];
		BFS(init);
			
		br.close();
	}
	
	static void DFS(int now) {
		System.out.print(now + " ");
		visited[now] = true;
		for(int e : edge[now])
			if(!visited[e])
				DFS(e);
	}
	static void BFS(int init) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(init);
		visited[init] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for(int e : edge[now]) {
				if(!visited[e]) {
					queue.add(e);
					visited[e] = true;
				}
			}
		}		
	}

}
