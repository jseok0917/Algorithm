package BOJ_1715_카드셔플;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] count = new int[1001];
		
		//설계 아이디어:
		//
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[i] = num;
			count[num]++;
		}
		
		
		//최소비교횟수 구하기
		//횟수
		long sum = 0;
		
		//쌓인 카드 수
		long stackCards = 0;
		
		//처음에는 카드만쌓고 횟수를 더하면 안된다.
		boolean firstCount = true;
		for (int i = 1; i <= 1000; i++) {
			if (count[i] != 0 && firstCount) {
				stackCards += i;
				firstCount = false;
				
				for (int j = 1; j < count[i]; j++) {
					sum += stackCards+i;
					stackCards += i;
				}			
			} else if (count[i] != 0 && !firstCount) {
				for (int j = 0; j < count[i]; j++) {
					sum += stackCards+i;
					stackCards += i;
				}
			}
			
		}
		
		System.out.println(sum);
		
	
	}

}
