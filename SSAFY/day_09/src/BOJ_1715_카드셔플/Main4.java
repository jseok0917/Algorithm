package BOJ_1715_카드셔플;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		//설계 아이디어:
		//Map과 DP를 활용
		int[] count = new int[1001];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			count[num]++;
		}
		
		ArrayList<Integer> nums = new ArrayList<>();
		
		for (int i = 1; i <= 1000; i++) {
			if (count[i] != 0) {
				for (int j = 0; j < count[i]; j++) {
					nums.add(i); 
				}
			}
		}
		
		
		int sum = 0;
		while (nums.size() > 1){
			
			//카드뭉치를 합친다
			int temp = nums.get(0)+nums.get(1);
			
			//합치는 과정에서 정렬 횟수를 더해준다
			sum += temp;
			//합쳤으므로 기존 카드뭉치는 삭제
			nums.remove(0);
			nums.remove(0);
			
			//합친 카드 뭉치를 정렬을 유지한 상태로 추가
			nums.add(temp);
			for (int i = 0; i < nums.size(); i++) {
				if ()
			}
			
		}
		
		
		
		
	
	}
	//Radix정렬을 사용하는게 가장 깔끔

}
