package SWEA_1230_암호문3;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			LinkedList<Integer> cryptoList = new LinkedList<>();
			
			//암호문의 개수
			int N = sc.nextInt();
			//암호문 입력
			for (int i = 0; i < N; i++) {
				cryptoList.add(sc.nextInt());
			}
			
			//명령어의 개수
			int M = sc.nextInt();
		f1:	for (int i = 0; i < M; i++) {
				String command = sc.next(); 
				if (command.equals("I")) {
					//x번째 암호문 뒤에 삽입할 예정
					int x = sc.nextInt();
					//삽입할 암호문의 갯수
					int y = sc.nextInt();
					
					//x번째자리는 index상으로는 x-1이지만
					//어차피 x번째까지는 냅두고 뒤에걸 밀어야한다.
					for (int j = 0; j < y; j++) {
						cryptoList.add(x+j, sc.nextInt());
					}
					
					
				} else if (command.equals("D")) {
					//x번째 암호문부터 삭제
					int x = sc.nextInt();
					//삭제할 암호문의 갯수
					int y = sc.nextInt();
					
					//삭제하는 자리는 고정이다.
					for (int j = 0; j < y; j++) {
						cryptoList.add(x-1);
					}
					
					
				} else if (command.equals("A")) {
					//삽입할 암호문의 갯수
					int y = sc.nextInt();
					
					//마지막 자리에만 삽입하므로
					for (int j = 0; j < y; j++) {
						cryptoList.addLast(sc.nextInt());
					}
					
					
				}
				
				
				
			}
			
			System.out.print("#"+tc);
			for (int i = 0; i < 10; i++) {
				System.out.print(" "+cryptoList.get(i));
			}
			System.out.println();
		
		
		
		
		}
		
	}

}
