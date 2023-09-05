package SWEA_3499_퍼펙트셔플;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for (int tc = 1; tc <= T; tc++) {
			//섞어야 될 덱의 크기 입력
			int N = sc.nextInt();
			String[] Queue = new String[N];
			
			//첫번째 카드는 그냥 출력한다
			System.out.printf("#%d %s", tc, sc.next());
			
			//이후 절반의 카드는 큐에 넣고
			for (int i = 1; i <= (N-1)/2; i++) {
				enQueue(Queue, sc.next());
			}
			
			//나머지 절반의 카드는 입력 직후 바로 출력하고, 큐에 있는 것들도 출력하며 번갈아 꺼낸다.
			for (int i = (N+1)/2; i < N; i++) {
				System.out.printf(" %s", sc.next());
				//큐가 비었을 때 null이 출력되는 것을 방지하기 위해
				if (!(isEmpty(Queue))) {
					System.out.printf(" %s", deQueue(Queue));
				}
			}
			
			//static 변수로 놓은 것들이라
			//테스트케이스 다시돌때마다 front rear값 초기화시켜줘야함
			front = -1;
			rear = -1;
			System.out.println();
	
		}
		

		
	}
	
	//Queue 메서드를 직접 구현.
	static int front = -1;
	static int rear = -1;
	
	public static boolean isFull(String[] Queue) {
		return rear == Queue.length-1;
	}
	
	public static boolean isEmpty(String[] Queue) {
		return rear == front;
	}
	

	public static String enQueue(String[] Queue, String item) {
		if (isFull(Queue)) {
			System.out.println("꽉 찼습니다.");
			return null;
		}
		
		Queue[++rear] = item;
		return Queue[rear];
	}
	
	public static String deQueue(String[] Queue) {
		if (isEmpty(Queue)) {
			System.out.println("비었습니다...");
			return null;
		}
		
		return Queue[++front];
	}
	
	
	
	
	
}
