package BOJ_1715_카드셔플;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		//설계 아이디어:
		//LinkedList를 2개 활용한다.
		int[] count = new int[1001];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			count[num]++;
		}
		
		LinkedList<Integer> nums = new LinkedList<>();
		LinkedList<Integer> nums2 = new LinkedList<>();
		
		//정렬 상태로 연결리스트에 숫자를 삽입
		for (int i = 1; i <= 1000; i++) {
			if (count[i] != 0) {
				for (int j = 0; j < count[i]; j++) {
					nums.add(i);
				}
			}
		}
		
	
		long sum = 0;
		while (!((nums.isEmpty()) && nums2.size() == 1)) {
			//첫번째 리스트 원소가 2개이상 존재, 두번째 리스트에는 원소가 x
			if (nums.size() >= 2 && nums2.isEmpty()) {
				int A1 = nums.get(0);
				int A2 = nums.get(1); 
				sum += A1+A2;
				nums2.add(A1+A2);
				nums.pollFirst();
				nums.pollFirst();
			//첫번째 리스트에도 원소가 두 개 이상 존재, 두번째 리스트에 원소가 단 한개만 존재
			} else if (nums.size() >= 2 && nums2.size() == 1) {
				int A1 = nums.get(0);
				int A2 = nums.get(1);
				int B = nums2.get(0);
				if (A2 <= B) {
					//합에 더하고, 넣고, 빼야한다.
					sum += A1+A2;
					nums2.add(A1+A2);
					nums.pollFirst();
					nums.pollFirst();
				} else {
					sum += A1+B;
					nums2.add(A1+B);
					nums.pollFirst();
					nums2.pollFirst();
				}
				
			//두번째 리스트에 원소가 두 개 이상 존재하고, 첫번째 리스트에도 원소가 두 개 이상 존재.
			} else if (nums.size() >= 2 && nums2.size() >= 2) {
				int A1 = nums.get(0);
				int A2 = nums.get(1);
				int B1 = nums2.get(0);
				int B2 = nums2.get(1);
				
				if (A2 <= B1) {
					sum += A1+A2;
					nums2.add(A1+A2);
					nums.pollFirst();
					nums.pollFirst();
				} else if (B2 <= A1) {
					sum += B1+B2;
					nums2.add(B1+B2);
					nums2.pollFirst();
					nums2.pollFirst();
				} else {
					sum += A1+B1;
					nums2.add(A1+B1);
					nums.pollFirst();
					nums2.pollFirst();
				}
				
			
			} else if (nums.size() == 1 && nums2.size() >= 2) {
				//첫번째 리스트에 원소가 1개 남았고, 두번째 리스트에 원소가 2개 이상일 경우	
				int A = nums.get(0);
				int B1 = nums2.get(0);
				int B2 = nums2.get(1);
				
				if (A <= B2) {
					sum += A+B1;
					nums2.add(A+B1);
					nums.pollFirst();
					nums2.pollFirst();
				} else {
					sum += B1+B2;
					nums2.add(B1+B2);
					nums2.pollFirst();
					nums2.pollFirst();
					
				}
			//첫번째 리스트에 원소가 1개 남았고, 두번째 리스트에 원소가 1개인 경우
			} else if (nums.size() == 1 && nums2.size() == 1) {
				int A = nums.get(0);
				int B = nums2.get(0);
				sum += A+B;
				nums2.add(A+B);
				nums.pollFirst();
				nums2.pollFirst();
			//첫번째 리스트에 원소가 0개 남았고, 두번째 리스트에만 원소가 있는 경우
			} else if (nums.isEmpty() && nums2.size() >= 2) {
				int B1 = nums2.get(0);
				int B2 = nums2.get(1);
				sum += B1+B2;
				nums2.add(B1+B2);
				nums2.pollFirst();
				nums2.pollFirst();
			//마지막 예외
			} else if (nums.size() == 1 && nums2.isEmpty()) {
				break;
			}

			
		}
		
		bw.write(sum+"");
		bw.flush();
		bw.close();
		
		
		
		
	
	}

}
