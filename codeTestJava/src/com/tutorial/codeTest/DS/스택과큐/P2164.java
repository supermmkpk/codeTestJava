package com.tutorial.codeTest.DS.���ð�ť;

import java.util.*;

//ī�� ���� 
public class P2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //ī�� ���� 
		
		Queue<Integer> myQueue = new LinkedList<>();
		for(int i = 1; i <= N; i++) 
			myQueue.add(i);
		
		while(myQueue.size() > 1) {
			myQueue.poll(); //������
			myQueue.add(myQueue.poll()); //�� ���� �� �� �ڷ� �̵�			
		}
		System.out.println(myQueue.poll()); //������ ī�� ���
	}

}

/*
public class P2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //ī�� ���� 
		
		Deque<Integer> deque = new LinkedList<>();
		for(int i = 1; i <= N; i++) 
			deque.addLast(i);
		
		while(deque.size() > 1) {
			deque.removeFirst(); //�� �� ������
			deque.addLast(deque.pollFirst()); //�� ���� ���� �� ������ �̵�			
		}
		System.out.println(deque.pollFirst()); //������ ī�� ���
	}

}
*/