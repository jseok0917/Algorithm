import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int M;
	static List<Integer> nums;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new ArrayList<>();
		result = new int[M];
		selected = new boolean[N];
		
		//입력
		for (int i = 0; i < N; i++) {
			nums.add(sc.nextInt());
		}
		
		Collections.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}	
		});
		
//		System.out.println(nums.toString());
		combination(0);
		
		
	}
	
	//cnt 뽑은 개수
	static int cnt = 0;
	//뽑았는지 안뽑았는지 판단할 
	static boolean[] selected;
	
	//현재 판단하고 있는 인덱스 위치
	static void combination(int idx) {
		if (cnt == M) {
			for (int i : result) {
				System.out.printf("%d ", i);
			}
			System.out.print("\n");
			return;
		}
		
		if (idx == N) {
			return;
		}
		
//		int tmp = result[cnt];
		//뽑거나
		result[cnt] = nums.get(idx);
		cnt++;
		combination(idx+1);
		
		//안뽑거나
		cnt--;
		combination(idx+1);
		
		
		
	}

}
