package SWEA_7102_준홍이의카드놀이;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			//설계 아이디어 :
			//무조건 N을 큰 것으로
			//M을 작은 것으로 생각한다.
			//이제 큐를 두 개 만들어
			//첫번째 큐에는 M ~ 1까지 내림차순으로 넣어놓고,
			//두번째 큐에는 1 ~ N까지 오름차순으로 넣어놓는다.
			//이제 첫번째 큐와 두번째 큐에서 동시에 poll(dequeue)을 진행한다.
			//첫번째 큐에서 poll한 후, 첫번째 큐가 비었는지 판정하고 두번째 큐의 poll을 진행
			//첫번째 큐가 비었을 때부터, (poll)
			//두번째 큐에서 poll로 반환되는 정수값에 차례대로 1씩 더한게
			//바로 우리가 구하는 등장할 확률이 가장 높은 것들이 된다.
			int N = Math.max(n, m);
			int M = Math.min(n, m);
		
			//큐 인터페이스를 직접적으로 활용하여 풀이
			Queue<Integer> q1 = new LinkedList<>();
			Queue<Integer> q2 = new LinkedList<>();
			
			//M~1까지 q1에 입력
			for (int i = M; i >= 1; i--) {
				q1.add(i);
			}
			
			//1~N까지 q2에 입력
			for (int i = 1; i <= N; i++) {
				q2.add(i);
			}
			
			
			System.out.printf("#%d", tc);
			//q2에 쌓을 숫자 카운트
			for (int i = 1; i <= N; i++) {
				q1.poll();
				
				//q1이 비게되면 q2의 poll과 동시에 출력을 시작
				if (q1.isEmpty()) {
					System.out.printf(" %d", q2.poll()+1);
				//q1이 비어있지 않으면 q2는 poll만 진행
				} else {
					q2.poll();
				}
				
			}
			
			System.out.println();
			

		
		}
	}

}
