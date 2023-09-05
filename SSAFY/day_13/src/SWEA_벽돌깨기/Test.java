package SWEA_벽돌깨기;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		W = 3;
		
		bruteForce(3);
		
		
	}
	
	static int W;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void bruteForce(int N) {
		
		if (N == 0) {
			System.out.println(list.toString());
			ArrayList<Integer> tmpList = list;
			
			list.remove(list.size()-1);
		} else {
			//N번째에
			//어느열에 구슬을 쏠 지 결정하기 위해
			for (int j = 0; j < W; j++) {
				list.add(j);
				bruteForce(N-1);
			}
			
			if (list.size() != 0) {
				list.remove(list.size()-1);
			}
		}
		
		
		
	}

}
