package com.tutorial.codeTest.DS.스택과큐;

import java.util.*;

//카드 게임 
public class P2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //카드 개수 
		
		Queue<Integer> myQueue = new LinkedList<>();
		for(int i = 1; i <= N; i++) 
			myQueue.add(i);
		
		while(myQueue.size() > 1) {
			myQueue.poll(); //버리고
			myQueue.add(myQueue.poll()); //맨 앞의 것 맨 뒤로 이동			
		}
		System.out.println(myQueue.poll()); //마지막 카드 출력
	}

}

/*
public class P2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //카드 개수 
		
		Deque<Integer> deque = new LinkedList<>();
		for(int i = 1; i <= N; i++) 
			deque.addLast(i);
		
		while(deque.size() > 1) {
			deque.removeFirst(); //맨 위 버리고
			deque.addLast(deque.pollFirst()); //맨 위의 것을 맨 밑으로 이동			
		}
		System.out.println(deque.pollFirst()); //마지막 카드 출력
	}

}
*/