import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스 입력
		int T = sc.nextInt();
	f1:	for (int tc = 1; tc <= T; tc++) {
			//사람수
			int N = sc.nextInt();
			//M초당
			int M = sc.nextInt();
			//K개의 붕어빵
			int K = sc.nextInt();
			
			//사람들이 언제 몇명오는지 입력받는데
			//삽입 정렬을 통해
			//처음 받을 때부터 오름차순으로 받는다.
			int[] peopleWhen = new int[N];
			
			//첫 원소는 바로 입력받기
			peopleWhen[0] = sc.nextInt();
			
			for (int i = 1; i < N; i++) {
				int input = sc.nextInt();
				int j = i;
				//우리가 넣어주는 input이
				//바로 앞에 있는 것보다 작으면
				//오름차순배열이므로 index(j를)왼쪽으로 당기고,
				//앞에있는걸 한칸 뒤로 민다.
				while (j > 0 && input < peopleWhen[j-1]) {
					peopleWhen[j] = peopleWhen[j-1];
					j--;
				}
				//이 과정을 반복하면
				//앞에 있는 게 없을 땐(j=0) 맨 앞에 input을 넣게되고
				//앞으로 당기다가 삽입해야될 곳을 찾으면(input >= peopleWhen[j-1])
				//앞보다 크거나 같을 때 집어넣어야 뒤에서부터 삽입중이므로 안정정렬이 된다.
				//(정렬 후에도 중복된 값의 순서가 유지)
				//반복문을 멈추고 j에 input을 넣으면 된다.
				peopleWhen[j] = input;
			}
			
			
			//사람이 올 때마다 붕어빵의 개수를 카운트 해줄
			//변수 생성
			int count = 0;
			//사람이 오는 시간 간격 사이에 몇 개의 붕어빵이 구워지는지를
			//판단하기 위한 시간 변수 생성
			int preTime = 0;
			
			for (int i = 0; i < N; i++) {
				//(i+1)번째 사람이 오는 시간
				int time = peopleWhen[i];
				//이전 시간까지 구워진 빵의 수
				int preBaked = (preTime/M)*K;
				
				//지금 시간까지 구워진 빵의 수
				int nowBaked = (time/M)*K;
				
				//지금 빵의 수 = 원래 갖고 있던 빵 + (지금 시간 빵 수 - 이전 시간 빵 수)
				count += nowBaked - preBaked;
				
				//온 사람이 빵을 하나 먹으므로
				count--;
				
				//빵이 부족한 지 판정해서, 부족할 경우 바로
				//반복문을 멈추고 impossible을 출력하고
				//다음 테스트케이스를 속행
				if (count < 0) {
					System.out.printf("#%d %s\n", tc, "Impossible");
					continue f1;
				}
				//이전 시간을 현재 시간으로 갱신
				preTime = time;
			}
			//위 반복문에서 impossible이 작동하지 않았다면
			//문제가 없었던 것이므로
			System.out.printf("#%d %s\n", tc, "Possible");

			
			
		}
		
		
	}

}
