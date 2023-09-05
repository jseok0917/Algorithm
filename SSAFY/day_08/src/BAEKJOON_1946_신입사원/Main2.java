package BAEKJOON_1946_신입사원;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt((br.readLine()));
			
			//성적 입력
			Map<Integer, Integer> grade = new HashMap<>();
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				grade.put(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
			}
			
			//탈락자 숫자
			int cnt = 0;
			
			//나보다 서류성적 높은 사람이
			//면접순위까지 높으면 난 탈락..
			
			//1번의 면접성적
			int high = grade.get(1);
			for (int i = 2; i <= N; i++) {
				if (grade.get(i) < high) {
				//i번째의 면접성적이  그 앞의 사람들의 면접성적보다 높아야 합격
					high = grade.get(i);
					
				} else {
				//높지 않으면 탈락
					cnt++;
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
