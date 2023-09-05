package BOJ_1715_카드셔플;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] count = new int[1001];
		
		//설계 아이디어:
		//10 10 20 30 40
//		1. 10+10 = 20  sum            // 20개 stackCards
//		2. 20+(20+20) = 60  sum        // 40개 stackCards
//		3. 60+(40+30) = 130 sum
//		4. 150+150+40
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[i] = num;
			count[num]++;
		}
		
		//카운팅정렬(사실 할필요없다)
		int[] sortedNums = new int[N];
		int cnt = 0;
		
		for (int i = 1; i <= 1000; i++) {
			if (count[i] != 0) {
				for (int j = 0; j < count[i]; j++) {
					sortedNums[cnt++] = i; 
				}
			}
		}
		
		//최소비교횟수 구하기
		long sum = 0;
		long stackCards = 0;
		for (int i = 0;)
		
	
	}

}
