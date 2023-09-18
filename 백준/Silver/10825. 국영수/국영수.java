import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//학생 수
		int N = Integer.parseInt(br.readLine());
		
		//정보 입력
		//4개의 정보
		String[][] scoreInfo = new String[N][4];
		
		for (int i = 0; i < N; i++) {
			scoreInfo[i] = br.readLine().split(" ");
		}
		
		//Arrays.sort(퀵정렬)를 이차원 배열에도 적용시키기 위해
		//Arrays.sort와 Collections.sort는 둘다 안정정렬이다
		Arrays.sort(scoreInfo, new Comparator<String[]>() {
			@Override
			//s1이라는 String배열과 s2라는 String배열을 직접적으로 비교하기 위한
			//class를 작성한다.
			public int compare(String[] s1, String[] s2) {
				if (Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])) {
					if (Integer.parseInt(s1[2]) == Integer.parseInt(s2[2])) {
						if (Integer.parseInt(s1[3]) == Integer.parseInt(s2[3])) {
							//s1과 s2의 성적이 완전히 동일하면 
							//s1과 s2의 이름순으로 배열한다.
							
							//기본세팅은 사전순
							return s1[0].compareTo(s2[0]);
							
						//국어점수와 영어점수가 동일하고
						//수학 성적이 다르면 
						//수학점수가 감소하는 순서로
						}
						
						return Integer.parseInt(s2[3])-Integer.parseInt(s1[3]);
						
					}
					
					//기본 순서는 오름차순
					//-값이면 앞에 있는 s1이 s1 < s2 이므로 순서 유지
					//+값이면 변경
					//같으면 변경x(안정정렬)
					return Integer.parseInt(s1[2])-Integer.parseInt(s2[2]);
					
				}
				return Integer.parseInt(s2[1])-Integer.parseInt(s1[1]);
				
				
				
				
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			sb.append(scoreInfo[i][0]+"\n");
		}
		
		System.out.println(sb.toString());
		
		
		
		
	}

}
