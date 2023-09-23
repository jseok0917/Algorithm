import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	//세그먼트 트리를 활용한다.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);
		
		// 2^k이 N보다 크거나같은 최소의 k값을 찾는다.
		int k = 0;
		while (Math.pow(2, k) < N) {
			k++;
		}
		
		L = (int) (Math.pow(2, k));
//		System.out.println(k);
//		System.out.println(K);
		
		//세그먼트 트리를 생성하기 위해 2*L 크기의 배열을 만든다
		//0번째 인덱스는 비워둔다
		segTree = new long[2*L];
		
		for (int i = 0; i < N; i++) {
			//L >= N이기 때문에 인덱스에러 안생김
			segTree[L+i] = Long.parseLong(br.readLine());
		}
		
		//부분합 구하기
		//할 때마다 두 칸씩
		while (L > 1) {
			for (int i = 0; i < L; i += 2) {
				segTree[(L+i)/2] = segTree[L+i]+segTree[L+i+1];
				
			}
			
			L = L/2;
		}
		
//		System.out.println(Arrays.toString(segTree));
		StringBuilder sb = new StringBuilder();
		
		L = (int) (Math.pow(2, k));
		
		//세그먼트 트리 작업을 완료하고 다음 M개의 줄에 대한 작업을 진행한다.
		for (int i = 0; i < M+K; i++) {
			String[] nums = br.readLine().split(" ");
			int a = Integer.parseInt(nums[0]);
			int b = Integer.parseInt(nums[1]);
			
			if (a == 1) {
				long c = Long.parseLong(nums[2]);
				change(b, c);
//				System.out.println(Arrays.toString(segTree));
			} else {
				int c = Integer.parseInt(nums[2]);
				sb.append(partialSum(L+b-1, L+c-1)+"\n");
			}
			
			
			
		}
		
		System.out.println(sb.toString());
		
		
		
	}
	
	static long[] segTree;
	static int L;
	
	static void change(int b, long c) {
		int idx = L+b-1;
		long diff = c - segTree[idx];
		segTree[idx] += diff;
		idx = idx/2;
		while (idx > 0) {
			segTree[idx] += diff;
			idx = idx/2;
		}
		
	}
	
	static long partialSum(int a, int b) {
		long sum = 0;
		
		while (a <= b) {
			if (a == b) {
				sum += segTree[a];
				break;
			}
			
			if (a%2 == 1) {
				sum += segTree[a];
				a = (a+1)/2;
			} else {
				a = a/2;
			}
			
			if (b%2 == 0) {
				sum += segTree[b];
				b = (b-1)/2;
			} else {
				b = b/2;
			}
			
			
		}
		
		return sum;
		
	}


}
