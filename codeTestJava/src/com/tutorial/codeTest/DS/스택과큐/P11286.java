package com.tutorial.codeTest.DS.스택과큐;

import java.io.*;
import java.util.PriorityQueue;

public class P11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> prQueue = new PriorityQueue<>((o1, o2) -> {
			int firstAbs = Math.abs(o1);
			int secondAbs = Math.abs(o2);
			
			if(firstAbs == secondAbs)
				return o1 > o2 ? 1 : -1; //절댓값 같으면 음수 우선 
			else
				return firstAbs - secondAbs; //절댓값 기준 정렬 
		});
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(prQueue.isEmpty())
					System.out.println("0");
				else 
					System.out.println(prQueue.poll());
			}
			else
				prQueue.add(input);
		}

	}

}
