import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
	f1:	for (int tc = 1; tc <= T; tc++) {
			//배열에 수행할 함수
			String[] functions = br.readLine().split("");
			
			//배열에 들어있는 수의 개수
			int N = Integer.parseInt(br.readLine());
			
			//입력할 배열
			String input = br.readLine();
			
			if (N == 0) {
				//배열의 크기가 0이라고 해도
				//삭제 함수가 존재하지 않으면 error가 아니라 빈 배열을 출력해야 한다.
				for (String i : functions) {
					if (i.equals("D")) {
						bw.write("error\n");
						continue f1;
					}
				}
				
				bw.write("[]\n");
				continue f1;
				
			} else {
				
				//substring, split 메서드를 이용한 문자열 가공
				//가공 후에는 length N의 배열이 된다.
				//이 과정 때문에 N==0일 때와 아닐 때로 굳이 구분한다
				String[] nums = input.substring(1, input.length()-1).split(",");
				
				//R을 구현할 two pointer와 boolean
				//숫자 배열의 시작 index를 가리킨다.
				int start = 0;
				//숫자 배열의 끝 index를 가리킨다
				int end = N-1;
				//뒤집혀있는지 아닌지 판별자
				boolean isReverse = false;
				
				//함수를 시행
				for (String i : functions) {
					switch (i) {
					case "R":
						int temp = start;
						start = end;
						end = temp;
						isReverse = !isReverse;
						break;
					case "D":
						//정상 순서일 때
						if (!isReverse) {
							//시작index가 끝index보다 커져있는 상태라면
							//추가적인 삭제가 불가능하므로 error를 출력하고
							//현재 케이스를 끝내고 다음 케이스 속행
							if (start > end) {
								bw.write("error\n");
								continue f1;
							} else {
								start++;
							}
						//뒤집혀있는 순서일 때
						} else {
							//시작index가 끝 index보다 작아져있는 상태라면
							//추가적인 삭제가 불가능하므로 error를 출력하고
							//현재 케이스를 끝내고 다음 케이스 속행
							if (start < end) {
								bw.write("error\n");
								continue f1;
							} else {
								start--;
							}
							
						}
						
					
					
					} //switch문 종료
				} //함수 수행 종료
				//함수 수행 종료 후 출력
				//정상 상태라면 start => end 오름차순으로 출력
				//뒤집힌 상태라면 start => end 거꾸로 내림차순 출력
				
				//아래에서 start end가 비정상적인 순서면 아예 for문을 돌지않으므로  빈 배열로 나온다
				if (!isReverse) {
					bw.write("[");
					for (int i = start; i <= end; i++) {
						if (i != end) {
							bw.write(nums[i]+",");
						} else {
							bw.write(nums[end]);
						}
					}
					bw.write("]");
					bw.write("\n");
				} else {
					bw.write("[");
					for (int i = start; i >= end; i--) {
						if (i != end) {
							bw.write(nums[i]+",");
						} else {
							bw.write(nums[end]);
						}
					}
					bw.write("]");
					bw.write("\n");
				}
				
				
			}
			
			
			
			
			
			
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
