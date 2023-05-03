package com.tutorial.codeTest.탐색.BFS;

import java.util.*;
import java.io.*;

//트리의 지름
public class P1167 {
	private static ArrayList<Edge>[] edge;
	private static int[] distance;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		
		edge = new ArrayList[V+1]; //인접리스트 초기화
        for(int i = 1; i <= V; i++)
            edge[i] = new ArrayList<Edge>();
        
		for(int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
            
            int dest;
			while((dest = Integer.parseInt(st.nextToken())) != -1) {
				int value = Integer.parseInt(st.nextToken());
				edge[now].add(new Edge(dest, value));
			}
		}
		
		visited = new boolean[V+1];
		distance = new int[V+1];
		BFS(1);
		int max = 1;
		for(int i = 2; i <= V; i++)
			if(distance[max] < distance[i])
				max = i;
		
		visited = new boolean[V+1];
		distance = new int[V+1];
		BFS(max);
        
		Arrays.sort(distance);
		System.out.println(distance[V]);
        br.close();
	}
	
	private static void BFS(int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(idx);
		visited[idx] = true;
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			for(Edge e : edge[tmp]) {
				int dest = e.dest;
				int value = e.value;
				if(!visited[dest]) {
					visited[dest] = true;
					queue.offer(dest);
					distance[dest] = distance[tmp] + value;
				}
			}
		}
	}
}

class Edge {
	int dest;
	int value;
		
	public Edge(int dest, int value) {
		this.dest = dest;
		this.value = value;
	}
}