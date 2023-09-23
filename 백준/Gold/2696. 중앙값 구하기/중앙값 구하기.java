import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트케이스 개수
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			//수열의 크기
			int M = sc.nextInt();
			//중앙값을 찾기위한 최소힙과 최대힙
			//최소힙에 중앙값보다 큰 원소들을,
			//최대힙에 중앙값보다 작은 원소들을 넣는다.
			PriorityQueue<Integer> minQ = new PriorityQueue<>();
			PriorityQueue<Integer> maxQ = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
				
			});
			
			//출력을 위한 StringBuilder
			StringBuilder sb = new StringBuilder();
			sb.append((M+1)/2+"\n");
			//M이 1이면 하나만 받고 끝
			if (M == 1) {
				int first = sc.nextInt();
				sb.append(first+" ");
			//1이 아니면 3이상이고,
			} else {
				//첫 원소와 두번 째 원소는 수동으로
				int first = sc.nextInt();
				int second = sc.nextInt();
				
				//첫 원소는 반드시 중앙값임
				sb.append(first+" ");
				
				if (first > second) {
					minQ.add(first);
					maxQ.add(second);
				} else {
					maxQ.add(first);
					minQ.add(second);		
				}
				
				
				for (int i = 3; i <= M; i++) {
					//입력받고
					//이제부터 중앙값을 찾는다.
					int num = sc.nextInt();
					int Lmax = maxQ.peek();
					int Rmin = minQ.peek();
					
//					System.out.println(i+"번째 숫자를 입력받았을 때 입니다.");
//					System.out.println(maxQ.toString());
//					System.out.println(minQ.toString());
					//두 힙의 사이즈를 항상 같도록 유지하면
					//같을 때가 홀수개의 숫자를 입력받았을 때다
					if (minQ.size() == maxQ.size()) {
						if (num <= Lmax) {
							maxQ.add(num);
							sb.append(maxQ.peek()+" ");
						} else {
							minQ.add(num);
							sb.append(minQ.peek()+" ");
						}
						
					} else if (minQ.size() > maxQ.size()) {
						//minQ의 크기가 maxQ보다 클 때
						//num이 maxQ에 들어갈 상황이면 문제가 없지만,
						//minQ에 들어갈 상황이라면
						//minQ의 사이즈가 커진 상태가 유지되므로
						//minQ의 최솟값을 maxQ로 옮기고, num을 minQ에 넣는다.
						if (num <= Rmin) {
							maxQ.add(num);
						} else {
							maxQ.add(minQ.poll());
							minQ.add(num);
						}	
					} else {
						//maxQ의 크기가 minQ보다 클 때
						//num이 minQ에 들어갈 상황이면 문제가 없지만,
						//maxQ에 들어갈 상황이라면
						//maxQ의 사이즈가 커진 상태가 유지되므로
						//maxQ의 최댓값을 minQ로 옮기고, num을 maxQ에 넣는다.
						if (num >= Lmax) {
							minQ.add(num);
						} else {
							minQ.add(maxQ.poll());
							maxQ.add(num);
						}
						
					}
					
					
				}
				
			}
			
			System.out.println(sb.toString());
			
			
		}
		
		
	}

}
