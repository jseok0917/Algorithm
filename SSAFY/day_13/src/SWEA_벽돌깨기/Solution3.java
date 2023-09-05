package SWEA_벽돌깨기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {

	// 메인함수
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       
        //테스트 케이스
        int T = sc.nextInt();
       
        for (int tc = 1; tc <= T; tc++){
	       //구슬 발사 횟수 입력
	        int N = sc.nextInt();
	         
	        //너비, 높이 입력
	        W = sc.nextInt();
	        H = sc.nextInt();
	        
	        //벽돌 전체갯수
	        brickCount = 0;
	        
	        //매 케이스마다 카운트를 0으로 초기화
	        cnt = 0;
	        
	        bricks = new int[H][W];
	        for (int i = 0; i < H; i++) {
	        	for (int j = 0; j < W; j++) {
	        		bricks[i][j] = sc.nextInt();
	        		if (bricks[i][j] != 0) {
	        			//벽돌 전체 갯수 카운트
	        			brickCount++;
	        		}
	        	}
	        }
	        
	        l = 0;
	        min = Integer.MAX_VALUE;
	        ArrayList<Integer> list = new ArrayList<>();
	        permute(N, l, list);
	        
	        System.out.println(min);

	        
	        
	        
	        
	       
        }
    }

	// 메서드 구현파트

	static int W;
	static int H;
	static int cnt = 0;

	// 폭발 후 빈칸을 메꾸는 정렬 시행
	public static void sortBricks(int[][] bricks) {

		// 카운팅 정렬을 이용
		// 열별로 정렬한다.

		for (int j = 0; j < W; j++) {
			int[] nums = new int[H];
			for (int i = 0; i < H; i++) {
				nums[i] = bricks[i][j];
			}

			// 폭탄의 폭발범위는 최대 9이다
			// 하지만 0을 모두 밀어올릴 예정이므로
			int[] count = new int[2];

			for (int i = 0; i < H; i++) {
				if (nums[i] > 0) {
					count[1]++;
				} else {
					count[0]++;
				}
			}

			// 누적합 구하기
			count[1] += count[0];

			// 0부터 오름차순 보내는 정렬
			int[] sortedNums = new int[H];
			for (int i = H - 1; i >= 0; i--) {
				if (nums[i] > 0) {
					sortedNums[--count[1]] = nums[i];
				} else {
					sortedNums[--count[0]] = nums[i];
				}
			}

			// j번째 열을 모두 sortedNums로 변경한다
			for (int i = 0; i < H; i++) {
				bricks[i][j] = sortedNums[i];
			}

		}

	}

	// 폭발시 생기는 일 재귀함수로 정의
	public static void bombBricks(int[][] bricks, int m, int n, int bombRange) {

		if (bricks[m][n] == 0) {
			return;
		} else if (bricks[m][n] == 1) {
			bricks[m][n] = 0;
			cnt++;
			return;
		} else {
			// 상하좌우 모두 지워야 한다.

			// 먼저 자기자신부터 터뜨려주고
			bricks[m][n] = 0;
			cnt++;
			// 상
			for (int i = 1; m - i >= 0 && i < bombRange; i++) {
				bombBricks(bricks, m - i, n, bricks[m - i][n]);
			}
			// 하
			for (int i = 1; m + i < H && i < bombRange; i++) {
				bombBricks(bricks, m + i, n, bricks[m + i][n]);
			}
			// 좌
			for (int i = 1; n + i < W && i < bombRange; i++) {
				bombBricks(bricks, m, n + i, bricks[m][n + i]);
			}
			// 우
			for (int i = 1; n - i >= 0 && i < bombRange; i++) {
				bombBricks(bricks, m, n - i, bricks[m][n - i]);
			}

		}

	}

	// 완전 탐색을 위한 중복 순열 구현
	// W개의 열중에 N개를 택한다.
	static int l = 0;
	static int[][] bricks;
	static int brickCount;
	static int min;

	public static void permute(int N, int l, ArrayList<Integer> list) {
		list.add(l);
		N--;

		if (N == -1) {
			//list에는 재귀호출에 의하여 중복순열의 모든 경우의 수를 순회하게 된다.
			
			//list에 들어간 각 숫자들에 대하여 Bomb을 한다.
			int[][] tempBricks = bricks;
			int tempBrickCount = brickCount;
			int tempCnt = cnt;
			
			for (int j = 1; j < list.size(); j++) {
				int S = list.get(j);
				int tmp = 0;
				for (int i = 0; i < H; i++) {
					if (tempBricks[i][S] != 0) {
						tmp = i;
						break;
					}

				}
				bombBricks(tempBricks, tmp, S, tempBricks[tmp][S]);
				sortBricks(tempBricks);
			}
			if (tempBrickCount - tempCnt < min) {
				min = tempBrickCount - tempCnt;
				System.out.println(min);
			}
			list = new ArrayList<Integer>();
			

		} else {

			for (int i = 0; i < W; i++) {
				permute(N, i, list);

			}

		}

	}

}