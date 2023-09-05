package BOJ_1799_비숍;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		diagonalList = new int[2 * N - 1][2][];
		diagonalList2 = new int[2 * N - 1][2][];
		checkDiagonal = new boolean[2 * N - 1];
		checkDiagonal2 = new boolean[2 * N - 1];
		for (int i = 0; i < 2 * N - 1; i++) {
			getDiagonal(i);
			getDiagonal2(i);
		}

		chess = new int[N][N];
		check = new boolean[N][N];

		// 체스판의 상태 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				chess[i][j] = sc.nextInt();
			}
		}

		maxBishop(0, 0);
		System.out.println(max);

	}

	// 체스판의 크기
	static int N;
	static int[][] chess;
	static boolean[][] check;

	// 체스판에서
	// 우측아래로 내려가는 대각방향 점들의 배열(대각행들) 번호 매기기

	// 일단 0행 고정시켜서 열을 이동시켜가며 0~N-1번까지 지정
	// 그다음 1행 0열에서 시작하여 N-1행 0열까지 N~2N-2번까지 지정

	// idx번째의 0번에는 행좌표, 1번에는 열좌표를 저장한다.
	static int[][][] diagonalList;
	static int[][][] diagonalList2;

	public static void getDiagonal(int idx) {
		if (idx < N) {
			// 참조변수 문제가 생기지 않을까?
			int[] tempRow = new int[N - idx];
			int[] tempCol = new int[N - idx];
			for (int i = 0; idx + i < N; i++) {
				// 행좌표 저장
				tempRow[i] = i;
				// 열좌표 저장
				tempCol[i] = idx + i;
			}
			diagonalList[idx][0] = tempRow;
			diagonalList[idx][1] = tempCol;
		} else {
			// idx값이 N부터 시작하게 된다.
			int[] tempRow = new int[2 * N - 1 - idx];
			int[] tempCol = new int[2 * N - 1 - idx];
			for (int i = 0; idx + i - N + 1 < N; i++) {
				// 행좌표 저장
				tempRow[i] = idx + i - N + 1;
				// 열좌표 저장
				tempCol[i] = i;
			}
			diagonalList[idx][0] = tempRow;
			diagonalList[idx][1] = tempCol;

		}

	}

	// 오른쪽 대각선 위로 올라가는 대각선 배열 저장
	public static void getDiagonal2(int idx) {
		if (idx < N) {
			// 참조변수 문제가 생기지 않을까?
			int[] tempRow = new int[idx + 1];
			int[] tempCol = new int[idx + 1];
			for (int i = 0; i < idx + 1; i++) {
				// 행좌표 저장
				tempRow[i] = idx - i;
				// 열좌표 저장
				tempCol[i] = i;
			}
			diagonalList2[idx][0] = tempRow;
			diagonalList2[idx][1] = tempCol;
		} else {
			// idx값이 N부터 시작하게 된다.
			int[] tempRow = new int[2 * N - 1 - idx];
			int[] tempCol = new int[2 * N - 1 - idx];
			for (int i = 0; idx - N + 1 + i < N; i++) {
				// 행좌표 저장
				tempRow[i] = N - 1 - i;
				// 열좌표 저장
				tempCol[i] = idx - N + 1 + i;
			}
			diagonalList2[idx][0] = tempRow;
			diagonalList2[idx][1] = tempCol;

		}

	}

	static boolean[] checkDiagonal;
	static boolean[] checkDiagonal2;
	static int max = Integer.MIN_VALUE;

	public static void maxBishop(int cnt, int col) {

		if (col == 2 * N - 1) {
			System.out.println("col이 2N-1일때 카운트 : " + cnt);
			System.out.println("cnt값"+cnt);
			if (cnt > max) {
				max = cnt;
			}
			return;

		} else if (col < N) {
			System.out.println("col값 : " + col);
			f1: for (int i = 0; i < col + 1; i++) {
				// 행좌표, 열좌표 불러오기
				int A = diagonalList2[col][0][i];
				int B = diagonalList2[col][1][i];
				System.out.println("A값 :" + A + " B값 :" + B);
				// 놓을 수 없는 곳이라면 속행
				if (chess[A][B] == 0 && i == col) {
					maxBishop(cnt, col + 1);
					return;
				} else if (chess[A][B] == 0) {
					continue;
				}

				// 우하향, 좌상향 대각선에 돌이 놓여있는지 없는지 체크
				for (int k = 0; A + k < N && B + k < N; k++) {
					if (check[A + k][B + k] == true) {
						continue f1;
					}
				}

				for (int k = 0; A - k >= 0 && B - k >= 0; k++) {
					if (check[A - k][B - k] == true) {
						continue f1;
					}
				}

				// 체크해도 문제가 없다면 대각선 파트를 전부 놓을 수 없는 곳으로 바꾼다
				chess[A][B] = 0;
				for (int k = 0; A + k < N && B + k < N; k++) {
					check[A][B] = true;
				}

				for (int k = 0; A - k >= 0 && B - k >= 0; k++) {
					check[A][B] = true;
				}
				// 놓았을 경우 놓은 개수를 카운트하는 cnt

				maxBishop(cnt + 1, col + 1);
				chess[A][B] = 1;
				for (int k = 0; A + k < N && B + k < N; k++) {
					check[A][B] = false;
				}

				for (int k = 0; A - k >= 0 && B - k >= 0; k++) {
					check[A][B] = false;
				}

			}

		} else {

		f2: for (int i = 0; i < 2 * N - 1 - col; i++) {
				System.out.println("col값 : " + col);
				// 행좌표, 열좌표 불러오기
				int A = diagonalList2[col][0][i];
				int B = diagonalList2[col][1][i];
				System.out.println("A값 :" + A + " B값 :" + B);
				System.out.println("i값 : " + i);
				// 놓읗 수 없는 곳이라면 속행
				if (chess[A][B] == 0 && i == 2 * N - 2 - col) {
					System.out.println("chess[A][B]가 0이고 i가 마지막일때");
					maxBishop(cnt, col + 1);
					return;
				} else if (chess[A][B] == 0) {
					continue;
				}

				// 우하향, 좌상향 대각선 체크
				for (int k = 1; A + k < N && B + k < N; k++) {
					if (check[A + k][B + k] == true) {
						if (i == 2 * N - 2 - col) {
							maxBishop(cnt, col + 1);
							return;
						}
						continue f2;
					}
				}

				for (int k = 1; A - k >= 0 && B - k >= 0; k++) {
					if (check[A - k][B - k] == true) {
						if (i == 2 * N - 2 - col) {
							maxBishop(cnt, col + 1);
							return;
						}
						continue f2;
					}
				}

				// 체크해도 문제가 없다면 대각선 파트를 전부 놓을 수 없는 곳으로 바꾼다
				for (int k = 0; A + k < N && B + k < N; k++) {
					check[A][B] = true;
				}

				for (int k = 0; A - k >= 0 && B - k >= 0; k++) {
					check[A][B] = true;
				}
				// 놓았을 경우 놓은 개수를 카운트하는 cnt
				System.out.println(cnt);
				maxBishop(cnt + 1, col + 1);
				for (int k = 0; A + k < N && B + k < N; k++) {
					check[A][B] = true;
				}

				for (int k = 0; A - k >= 0 && B - k >= 0; k++) {
					check[A][B] = true;
				}

			}

		}

	}

}
