import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	//세그먼트 트리를 활용한다.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// 2^k이 N보다 크거나같은 최소의 k값을 찾는다.
		int k = 0;
		while (Math.pow(2, k) < N) {
			k++;
		}
		
		L = (int) (Math.pow(2, k));
		
		//세그먼트 트리를 생성하기 위해 2*L 크기의 배열을 만든다
		//0번째 인덱스는 비워둔다
		maxTree = new int[2*L];
		minTree = new int[2*L];
		
		
		for (int i = 0; i < N; i++) {
			//L >= N이기 때문에 인덱스에러 안생김
			maxTree[L+i] = Integer.parseInt(br.readLine());
			minTree[L+i] = maxTree[L+i];
		}
		
		
		int temp = L;
		//각 구간의 최댓값 저장하기
		//할 때마다 두 칸씩
		while (temp > 1) {
			for (int i = 0; i < temp; i += 2) {
				maxTree[(temp+i)/2] = Math.max(maxTree[temp+i], maxTree[temp+i+1]);
				
			}
			
			temp = temp/2;
		}
		
		//temp값 초기화
		temp = L;
		
		//각 구간의 최솟값 저장하기
		while (temp > 1) {
			for (int i = 0; i < temp; i += 2) {
				minTree[(temp+i)/2] = Math.min(minTree[temp+i], minTree[temp+i+1]);
				
			}
			
			temp = temp/2;
		}
		
//		System.out.println(Arrays.toString(minTree));
//		System.out.println(Arrays.toString(maxTree));
		
		
		StringBuilder sb = new StringBuilder();
		
		//세그먼트 트리 작업을 완료하고 다음 M개의 줄에 대한 작업을 진행한다.
		for (int i = 0; i < M; i++) {
			String[] nums = br.readLine().split(" ");
			int a = Integer.parseInt(nums[0]);
			int b = Integer.parseInt(nums[1]);
			sb.append(minSearch(L+a-1, L+b-1)+" ");
			sb.append(maxSearch(L+a-1, L+b-1)+"\n");
		}
		
		System.out.println(sb.toString());
		
		
		
	}
	
	static int[] maxTree;
	static int[] minTree;
	static int L;
	
	
	static int minSearch(int a, int b) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		while (a <= b) {
			if (a == b) {
				pq.add(minTree[a]);
				break;
			}
			
			if (a%2 == 1) {
				pq.add(minTree[a]);
				a = (a+1)/2;
			} else {
				a = a/2;
			}
			
			if (b%2 == 0) {
				pq.add(minTree[b]);
				b = (b-1)/2;
			} else {
				b = b/2;
			}
			
			
		}
		
		return pq.peek();
		
	}
	
	static int maxSearch(int a, int b) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}

		});
		
		while (a <= b) {
			if (a == b) {
				pq.add(maxTree[a]);
				break;
			}
			
			if (a%2 == 1) {
				pq.add(maxTree[a]);
				a = (a+1)/2;
			} else {
				a = a/2;
			}
			
			if (b%2 == 0) {
				pq.add(maxTree[b]);
				b = (b-1)/2;
			} else {
				b = b/2;
			}
			
			
		}
		
		return pq.peek();
		
	}


}
