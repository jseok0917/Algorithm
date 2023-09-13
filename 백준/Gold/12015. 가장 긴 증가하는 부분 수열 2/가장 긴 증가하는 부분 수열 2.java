import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//뒤에서부터 큰 값을 찾아나가되,
		//주어진 값보다 큰 값을 이진 탐색으로 구현한다.
		//큰 값을 찾을 때마다 전체탐색을 해야한다.
		
		//수열의 크기 
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		int[] seq = new int[N+1];
		
		//수열 입력(dp쓸때 index 안꼬이게 하려고)
		for (int i = 1; i < N+1; i++) {
			seq[i] = Integer.parseInt(input[i-1]);
		}
		
		
		//DP를 적용하기 위한 수열 생성
		int[] dp = new int[N+1];
		int length = 0;
		
		//dp 구현
		for (int i = 1; i < N+1; i++) {
			//dp의 마지막 값보다 넣어줄 값이 크거나 같으면
			//그냥 넣고 길이도 늘린다.
			if (seq[i] > dp[length]) {
				length++;
				dp[length] = seq[i];
			//dp의 마지막 값보다 작으면
			//넣어줄 그 값을
			//dp의 그 값의 정렬순서에 해당하는 위치에 넣어준다.
			} else {
				if (length == 1) {
					if (dp[length] > seq[i]) {
						dp[length] = seq[i];
					}
				//길이가 1보다 클 때
				} else {
					binarySearch(dp, 1, length, seq[i]);
					if (idx == 2 && dp[idx-1] > seq[i]) {
						dp[idx-1] = seq[i];
					} else if (dp[idx] > seq[i] && !(dp[idx-1] == seq[i])) {
						dp[idx] = seq[i];
					}
				}
			}
			
		}
		
		System.out.println(length);
		
		
		
	}
	
	static int idx = 0;
	
	public static void binarySearch(int[] arr, int left, int right, int N) {
		
		//요렇게 두면 무조건 작은쪽으로 선택됨
		int mid = (left+right+1)/2;
//		이렇게두면 무조건 마지막에 right쪽으로 반환
//		int mid = (left+right+1)/2;
		//재귀 종료 조건
		if (mid == left || mid == right) {
			//지금 이렇게 종료조건을 주면
			//N보다 큰 값 바로 앞에 위치하게 된다.
			//같은 경우에는 mid+1을 넣어준다.
		
			idx = mid;
			return;
		}
		
		//탐색한 값이 클 경우 왼쪽으로 이분탐색을 진행한다.
		if (arr[mid] > N) {
			binarySearch(arr, left, mid, N);
		//작거나 같은 경우 오른쪽으로 이분 탐색을 진행한다.
		} else if (arr[mid] <= N) {
			binarySearch(arr, mid, right, N);
		} 
		
	}
	
	
	

	
}
