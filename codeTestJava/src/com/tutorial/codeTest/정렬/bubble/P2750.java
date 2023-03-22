package com.tutorial.codeTest.정렬.bubble;

import java.io.*;
import java.util.*;

/* BubbleSort */
/*
public class P2750 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		for(int i = 0; i < N-1; i++) {
			for(int j = 0; j < N-1-i; j++) {
				if(arr[j] > arr[j+1]) { //swap
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		for(int i = 0; i < N; i++)
			System.out.println(arr[i]);

	}

}
*/


/* Arrays.sort() 사용 */
/* 
public class P2750 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		for(int e : arr)
			bw.write(Integer.toString(e) + '\n');
		
		bw.flush();
		br.close();
		bw.close();
	}
}
*/

/* Deque, Stack 사용 */
public class P2750 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		
		dq.add(Integer.parseInt(br.readLine()));
		for(int i = 1; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(dq.getFirst() < input && input < dq.getLast()) {
				while(dq.getLast() > input) 
					stack.push(dq.pollLast());
				
				dq.addLast(input); 
				while(!stack.isEmpty())
					dq.addLast(stack.pop());
			}
			else if(input < dq.getFirst())
				dq.addFirst(input);
			else
				dq.addLast(input);
		}
		
		for(int i = 0; i < N; i++)
			bw.write(Integer.toString(dq.poll()) + '\n');
		
		bw.flush();
		br.close();
		bw.close();
	}
}
