package com.tutorial.codeTest.탐색.DFS;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class P13023 {
	static ArrayList<Integer>[] edge;
	static boolean[] visited;
	static boolean arrived; //재귀 깊이가 5이상으로 도달했는가?
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //사람의 수(노드 개수) N
		int edgeNum = Integer.parseInt(st.nextToken()); //관계의 수(엣지 개수) edgeNum
		
		edge = new ArrayList[N];
		for(int i = 0; i < N; i++)
			edge[i] = new ArrayList<Integer>(); //인접리스트 edge 초기화
		visited = new boolean[N];
		arrived = false;
		
		for(int i = 0; i < edgeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			edge[left].add(right); //친구관계이므로 방향이 없음
			edge[right].add(left);
		}
		
		for(int i = 0; i < N; i++) { //각 노드에 대하여 DFS
			DFS(i, 1);
			if(arrived)
				break;
		}
		System.out.println((arrived) ? "1" : "0");
		
		br.close();
	}
	
	static void DFS(int now, int depth) {
		//종료조건: 재귀 깊이가 5 도달 || arrived == true)
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
