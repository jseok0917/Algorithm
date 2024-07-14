package BOJ_19623_회의실배정4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
	
	//종료시간 오름차순으로 정렬한다.
	//임의로 고른 회의의 시작시간 이하의 종료시간들 중 최댓값을 선택하여
	//해당 종료시간을 가진 회의의 저장된 최대인원값을 가져온다
	//골랐던 회의에 가져온 최대인원값+고른 회의의 인원값을 더하여
	//저장한다.
	
	static List<int[]> meetings;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//회의의 수
		int N = Integer.parseInt(br.readLine());
		
		meetings = new ArrayList<>();
		
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int num = Integer.parseInt(input[2]);
			
			//시작시간, 종료시간, 회의인원 입력
			meetings.add(new int[] {start, end, num});
			
		}
		
		
		//종료시간 순으로 오름차순 정렬
		//종료시간이 같으면 강의 인원이 많은 순
		Collections.sort(meetings, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if (o1[0] != o2[0]) {
					return o1[1]-o2[1];					
				} else {
					return o2[2]-o1[2];
				}
			}
		
		});
		
		
		for (int[] i : meetings) {
			System.out.println(Arrays.toString(i));
		}
		
		
		
		
	}
	
	
	//이분탐색 구현
	//주어진 시작시간보다 작거나 같은 가장 큰 종료시간을 찾는다.
	//즉 lower bound를 찾는다.
	static int binarySearch(int stt, int end, int time) {
		
		
		return 0;
	}
	
	

}

/*
 10 50 50
 20 120 60
 30 60 100
 80 100 50
 110 140  70
 
 
*/
