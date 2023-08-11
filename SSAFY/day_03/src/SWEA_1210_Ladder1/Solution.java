package SWEA_1210_Ladder1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		Map<Integer, Integer> map = new HashMap();
//		// 맵 테스트
//		for (int i = 0; i < 100; i++) {
//			map.put(i, i); 
//		}
//		
//		map.replace(3, 7); // 밸류값 바꿔치기가 잘 되는가
//		System.out.println(map.get(3)); // 키밸류가 잘 들어가는가
		
//		int T = sc.nextInt();
//		sc.nextLine();
		
		//index문제를 생각하지 않아도 되게
		//애초부터 가로로 확장된 판으로 생각을 한다
		//행 pointer를 써서 순차적으로 바꿔치기 되는 부분을 기록한다.
		//bijection - cycle 
		
		
		List<Integer> cycle = new ArrayList<>();
		
		
		//입력받을 판
		int[][] ladder = new int[100][102];
		
		//입력
		for (int i = 0; i < 100; i++) {
			for (int j = 1; j < 101; j++) {
				ladder[i][j] = sc.nextInt();
			}
		}
		
		//도착위치 기록
		int arrival = 0;
		for (int j = 1; j < 101; j++) {
			if (ladder[99][j] == 2) {
				arrival = j;
				break;
			}
		}
		
		//이제 행포인터로 돌면서 사다리가 그어진 시점을 모두 기록한다.
		//도착위치에서 거꾸로 찾아나간다?
		
		for (int i = 99; i >= 0; i--) {
			for (int j = 1; j < 101; j++) {
				
				//시작지점 기록
				if (ladder[i][j-1] == 0 && ladder[i][j] == 1 && ladder[i][j+1] == 1) {
					cycle.add(j);
					
				//요건 끝지점 기록
				} else if (ladder[i][j-1] == 1 && ladder[i][j] == 1 && ladder[i][j+1] == 0) {
					cycle.add(j);
				}
				//시작이 있으면 끝이 있을 것이므로
				//cycle의 size는 반드시 짝수가 된다.

			}
		}
		
		//처음에 사다리에 아무것도 그려져 있지 않을때는
		//시작위치와 도착위치가 모두 같으므로
		Map<Integer, Integer> map = new HashMap();
		
		for (int i = 1; i <= 100; i++) {
			map.put(i, i);
		}
		
		//N은 반드시 짝수이다
		int N = cycle.size();
		//이제 Map을 이용해 도착위치 변화를 기록한다.
		for (int i = 0; i < N; i += 2) {
			
			int temp1 = 0;
			int temp2 = 0;
			for (int j = 1; j <= 100; j++) {
				if (map.get(j) == cycle.get(i)) {
					temp1 = j;
				}
			}
			
			for (int j = 1; j <= 100; j++) {
				if (map.get(j) == cycle.get(i+1)) {
					temp2 = j;
				}
			}
			
			int temp = cycle.get(i);
			map.replace(temp1, cycle.get(i+1));
			map.replace(temp2, temp);
			
	
		}
		
		System.out.println(arrival);
		System.out.println(cycle);
		
		System.out.println(map.get(arrival)-1);
		
	
		
	}

}
