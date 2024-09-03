package BOJ_11286_절대값힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	//최소힙을 이용하면 된다
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력값의 개수
		int N = Integer.parseInt(br.readLine());
		
		//출력값을 모을 곳
		StringBuilder sb = new StringBuilder();
		
		//최소힙
		//자바에서는 우선순위큐가 기본적으로 최소힙으로 구현돼있다
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				//o1과 o2의 절댓값
				int abs_o1 = Math.abs(o1.intValue());
				int abs_o2 = Math.abs(o2.intValue());
				
				//절댓값이 서로 다를 때는
				if (abs_o1 != abs_o2) {
					//절댓값 작은 순(오름차순)으로 정렬
					return abs_o1 - abs_o2;
					
					//절댓값이 값으면 더 작은 값을 작은걸로 취급
				} else {
					return o1-o2;
				}
			}
		});
		
		
		
//		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			//큐가 비어있고 입력값이 0(poll명령)인 경우
			if (pq.isEmpty() && input == 0) {
				int output = 0;
				sb.append(output+"\n");
			//큐가 채워져있고, 입력값이 0인 경우
			} else if (input == 0) {
				int output = pq.poll();
				sb.append(output+"\n");
			//큐가 채워져있고, 입력값이 0이 아닌경우
			} else {
				pq.add(input);
			}
			
		}
		
		System.out.println(sb.toString());
		
		
		
	}

}
