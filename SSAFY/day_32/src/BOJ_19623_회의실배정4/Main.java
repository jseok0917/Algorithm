package BOJ_19623_회의실배정4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
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
		
		
		Collections.sort(meetings, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				//오름차순으로 정렬
				return o1[0]-o2[0];
			}
		
		});
		
		
		for (int[] i : meetings) {
			System.out.println(Arrays.toString(i));
		}
		
		
		
		
	}

}

/*
 10 50 50
 20 120 60
 30 60 100
 80 100 50
 110 140  70
 
 
*/
