package BAEKJOON_1946_신입사원;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt((br.readLine()));
			
			//성적 입력 (0일때가 서류, 1일 때가 면접성적)
			int[][] grade = new int[2][N];
			
			
			//탈락자 숫자
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				grade[0][i] = Integer.parseInt(input[0]);
				grade[1][i] = Integer.parseInt(input[1]);
			}
			
			//카운팅 정렬
			int[] count = new int[N+1];
			
			//서류성적만 정렬할거고, 그걸 카운팅
			for (int i = 0; i < N; i++) {
				count[grade[0][i]]++;
			}
			//안정정렬해야 면접성적까지 순서 유지가 가능하다.
			//누적합
			for (int i = 1; i < N+1; i++) {
				count[i] += count[i-1];
			}
			
			//안정정렬
			//오름차순정렬
			int[][] gradeSort = new int[2][N];
			for (int i = N-1; i >= 0; i--) {
				gradeSort[0][--count[grade[0][i]]] = grade[0][i];
				gradeSort[1][count[grade[0][i]]] = grade[1][i];
			}
			
			//나보다 서류성적 높은 사람이
			//면접순위까지 높으면 난 탈락..
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i; j++) {
					if (i > (N+1)/2 && gradeSort[1][i] > (N+1)/2 ) {
						cnt++;
						break;
					} else if (gradeSort[1][i] > gradeSort[1][j]) {
						cnt++;
						break;
					}
				}
			}
			
//			System.out.println(Arrays.toString(gradeSort[0]));
//			System.out.println(Arrays.toString(gradeSort[1]));
			
			bw.write(N-cnt+"\n");

			
		}
		
		bw.flush();
		bw.close();
		
	}

}
