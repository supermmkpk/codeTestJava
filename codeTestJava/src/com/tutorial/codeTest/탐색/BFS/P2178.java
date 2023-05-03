package com.tutorial.codeTest.탐색.BFS;

import java.io.*;
import java.util.*;

public class P2178 {
	static int[][] maze;
	static int[] dx = {0, 0, -1, 1}; //상하좌우
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //미로의 행수 N
		M = Integer.parseInt(st.nextToken()); //미로의 열수 M
		
		visited = new boolean[N][M];
		maze = new int[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) 
				maze[i][j] = Integer.parseInt(line.substring(j,j+1));
		}
		
		BFS(0,0);
		System.out.println(maze[N-1][M-1]);
	}
	
	static void BFS(int rowInit, int colInit) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {rowInit, colInit}); //큐의 각 요소는 좌표형식으로 int[]가 들어감
		visited[rowInit][colInit] = true;
	
		while(!queue.isEmpty()) {
			int tmp[] = queue.poll();
			for(int i = 0; i < 4; i++) { //상하좌우 4번
				int row = tmp[0] + dx[i];
				int col = tmp[1] + dy[i];
				if(row >= 0 && col >= 0 && row < N && col < M) { //유효한 좌표인가?
					if(!visited[row][col] && maze[row][col] == 1) { //방문X && 이동 가능?
						visited[row][col] = true;
						maze[row][col] = maze[tmp[0]][tmp[1]] + 1; //1씩 누적
						queue.add(new int[] {row,col});
					}
				}
			}
		}
	}
	
}
