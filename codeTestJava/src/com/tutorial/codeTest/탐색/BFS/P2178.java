package com.tutorial.codeTest.Ž��.BFS;

import java.io.*;
import java.util.*;

public class P2178 {
	static int[][] maze;
	static int[] dx = {0, 0, -1, 1}; //�����¿�
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //�̷��� ��� N
		M = Integer.parseInt(st.nextToken()); //�̷��� ���� M
		
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
		queue.add(new int[] {rowInit, colInit}); //ť�� �� ��Ҵ� ��ǥ�������� int[]�� ��
		visited[rowInit][colInit] = true;
	
		while(!queue.isEmpty()) {
			int tmp[] = queue.poll();
			for(int i = 0; i < 4; i++) { //�����¿� 4��
				int row = tmp[0] + dx[i];
				int col = tmp[1] + dy[i];
				if(row >= 0 && col >= 0 && row < N && col < M) { //��ȿ�� ��ǥ�ΰ�?
					if(!visited[row][col] && maze[row][col] == 1) { //�湮X && �̵� ����?
						visited[row][col] = true;
						maze[row][col] = maze[tmp[0]][tmp[1]] + 1; //1�� ����
						queue.add(new int[] {row,col});
					}
				}
			}
		}
	}
	
}
