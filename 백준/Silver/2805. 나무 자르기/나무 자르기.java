import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		//나무의 수 N
		int N = Integer.parseInt(input[0]);
		
		//가져가려고 하는 나무의 길이 M
		int M = Integer.parseInt(input[1]);
		
		//나무의 높이
		String[] nums = br.readLine().split(" ");
		long[] height = new long[N];
		long max = 0;
		for (int i = 0; i < N; i++) {
			height[i] = Long.parseLong(nums[i]);
			//입력하며 높이의 최댓값 구하기
			if (max < height[i]) {
				max = height[i];
			}
		}
		
		//최저 높이 설정
		long min = 0;
		//자를 높이 설정
		long mid = (max+min)/2;
		
		while (min != mid) {
			long sum = 0;
			
			//자른 높이 구하기
			for (int i = 0; i < N; i++) {
				if (height[i] > mid) {
					sum += height[i]-mid;
				}
			}
			
//			System.out.println("max값 :"+max+", min값 :"+min+", mid값 :"+mid);
			//잘랐는데 부족하다면 구간을 좁혀서 더 잘라봐야함
			if (sum < M) {
				max = mid;
			//잘랐는데 넘쳤다면 덜 잘라봐야함
			} else {
				min = mid;
			}
			//자를 높이 설정
			mid = (max+min)/2;
		}
		
		System.out.println(mid);
		
		
		
		
		
	}

}
