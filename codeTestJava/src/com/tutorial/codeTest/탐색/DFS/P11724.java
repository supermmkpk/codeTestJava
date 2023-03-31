package com.tutorial.codeTest.탐색.DFS;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;

//연결요소 구하기 DFS
public class P11724 {
	static ArrayList<Integer>[] edge;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //노드의 개수 N
		int M = Integer.parseInt(st.nextToken()); //엣지의 개수 M
		
		edge = new ArrayList[N + 1];
		for(int i = 1; i < N + 1; i++)
			edge[i] = new ArrayList<Integer>();
		int u, v; //엣지의 양끝 u,v
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			edge[u].add(v); //방향이 없는 엣지
			edge[v].add(u);
		}
		
		int count = 0;
		visited = new boolean[N + 1];
		for(int i = 1; i < N + 1; i++) {
			if(!visited[i]) { //방문하지 않았다면 DFS, 연결요소 개수++
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
			if(!visited[e]) //연결 노드 중 방문하지 않았던 노드만 탐색
				DFS(e);
	}
	
}
