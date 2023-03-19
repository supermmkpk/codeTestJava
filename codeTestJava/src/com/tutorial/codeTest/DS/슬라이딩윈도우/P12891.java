package com.tutorial.codeTest.DS.�����̵�������;

import java.io.*;
import java.util.*;

//DNA ��й�ȣ
public class P12891 {
	static int secret[]; //��й�ȣ üũ �迭
	static int current[]; //���� ���� �迭
	static int check = 0; //ACGT �� ��ȿ���� �����ϴ� ����(4�̸� ��ȿ��)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int length = Integer.parseInt(st.nextToken()); //���ڿ� ����
		int partial = Integer.parseInt(st.nextToken()); //�κ� ���ڿ� ����
		int count = 0; //��ȿ ��й�ȣ�� ����
		
		char[] arr = new char[length]; //�Է� ���� �迭
		secret = new int[4];
		current = new int[4];
				
		arr = br.readLine().toCharArray();
		st =  new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			secret[i] = Integer.parseInt(st.nextToken()); //ACGT �ּ� ���� �Է�
			if(secret[i] == 0) //�ּҰ����� 0�̸� �̹� ������ ���̹Ƿ� �̿� ���� check++
				check++;
		}
		
		//�ʱ� ������
		for(int i = 0; i < partial; i++) 
			add(arr[i]);
		if(check == 4)
			count++;
		
		//�����̵� ������
		for(int i = partial; i < length; i++) { //�ʱ� �����쿡 ���� �����̵��ϹǷ� i�� partial~length-1���� add
			int j = i - partial;				//j�� 0~length-1-partial���� remove
			remove(arr[j]);
			add(arr[i]);
			if(check == 4)
				count++;
		}
		
		System.out.println(count);
		br.close();
	}
	
	public static void add(char c) {
		switch(c) {
		case 'A':
			if(++current[0] == secret[0])
				check++;
			break;
		case 'C':
			if(++current[1] == secret[1])
				check++;
			break;
		case 'G':
			if(++current[2] == secret[2])
				check++;
			break;
		case 'T':
			if(++current[3] == secret[3])
				check++;
			break;
		}
	}
	public static void remove(char c) {
		switch(c) {
		case 'A':
			if(current[0]-- == secret[0])
				check--;
			break;
		case 'C':
			if(current[1]-- == secret[1])
				check--;
			break;
		case 'G':
			if(current[2]-- == secret[2])
				check--;
			break;
		case 'T':
			if(current[3]-- == secret[3])
				check--;
			break;
		}
	}

}
