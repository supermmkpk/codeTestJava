package com.tutorial.codeTest.Ž��.DFS;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;

//������ ���ϱ� DFS
public class P11724 {
	static ArrayList<Integer>[] edge;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //����� ���� N
		int M = Integer.parseInt(st.nextToken()); //������ ���� M
		
		edge = new ArrayList[N + 1];
		for(int i = 1; i < N + 1; i++)
			edge[i] = new ArrayList<Integer>();
		int u, v; //������ �糡 u,v
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			edge[u].add(v); //������ ���� ����
			edge[v].add(u);
		}
		
		int count = 0;
		visited = new boolean[N + 1];
		for(int i = 1; i < N + 1; i++) {
			if(!visited[i]) { //�湮���� �ʾҴٸ� DFS, ������ ����++
				DFS(i);
				++count;
			}
			else
				continue;
		}
		System.out.println(count);
	}
	
	static void DFS(int v) {
		if(visited[v])
			return;
		visited[v] = true;
		for(int e : edge[v])
			if(!visited[e]) //���� ��� �� �湮���� �ʾҴ� ��常 Ž��
				DFS(e);
	}
	
}
