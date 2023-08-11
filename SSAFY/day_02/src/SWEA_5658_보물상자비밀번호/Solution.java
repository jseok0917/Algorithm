package SWEA_5658_보물상자비밀번호;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	//세자리 16진법수를 10진법으로 변환하는 메소드 구현
	public static int from16to10(String str) {
		
		int L = str.length();
		int sum = 0;
		for (int i = 0; i < L; i++) {
			
			int xtoInt;
			String x = str.substring(i, i+1);
			
			if (x.equals("A")) {
				xtoInt = 10;
			} else if (x.equals("B")) {
				xtoInt = 11;
			} else if (x.equals("C")) {
				xtoInt = 12;
			} else if (x.equals("D")) {
				xtoInt = 13;
			} else if (x.equals("E")) {
				xtoInt = 14;
			} else if (x.equals("F")) {
				xtoInt = 15;
			} else {
				xtoInt = Integer.parseInt(x);
			}
			
			for (int j = 0; j < L-1-i; j++) {
				xtoInt = xtoInt*16;
			}
			
			sum += xtoInt;
		}
		
		return sum;
		
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
//		sc.nextLine();
		
		for (int t = 0; t < T; t++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			
			String input = sc.nextLine();
			
			//문자열을 입력받아 input배열에 넣는다.

			
			// 기본적으로 N/4번째마다 숫자를 구분해야하므로 
			// i반복문을 N/4마다 돌린다.
			// 회전은 N/4까지 할 수 있으므로
			// k값을 통해 구현한다.
			
			List<Integer> nums = new ArrayList<>();
			
			for (int k = 0; k < N/4; k++) {
				for (int i = 0; i < N; i+=N/4) {
					
					String sum = "";
					
					//여기서 문자열을 완성한다.
					for (int j = 0; j < N/4; j++) {
						if (i+j+k >= N) {
							sum += input.substring((i+j+k)%(N/4), (i+j+k)%(N/4)+1);
							
						} else {
							sum += input.substring(i+j+k, i+j+k+1);
						}
					}
					
//					System.out.print(sum+" ");
					
					//구현한 메서드로 문자열을 10진법으로 변환한다.
					
					int sumtoInt = from16to10(sum);
//					System.out.print("\n");
//					System.out.print(sumtoInt+" ");
					nums.add(sumtoInt);
					
				}
			}
			
			//선택정렬을 통해 크기 순으로 나열한다 (내림차순)
			
			for (int i = 0; i < nums.size(); i++) {
				
				int idx = 0;
				int max = Integer.MIN_VALUE;
				
				for (int j = i; j < nums.size(); j++) {
					if (max <= nums.get(j)) {
						idx = j;
						max = nums.get(j);
					}
				}
				
				int temp = nums.get(i);
				nums.set(i, nums.get(idx));
				nums.set(idx, temp);
			}
			
			
//			for (int i : nums) {
//				System.out.print(i+" ");
//			}

			//중복을 구분하기 위해 한 번 더 순회하여 진짜 순서를 찾아준다
			int idx = 0;
			
			for (int i = 1; i < nums.size(); i++) {
				
				if (nums.get(i-1) > nums.get(i)) {
					idx++;
					if (idx == K) {
						System.out.println(nums.get(i-1));
						break;
					}
					
				}
				
				
			}
			
			
			
		}
		
	}
	
	
}
