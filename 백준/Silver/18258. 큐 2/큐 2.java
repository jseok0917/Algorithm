import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//큐 구현을 위해 LinkedList 선언
		LinkedList<Integer> que = new LinkedList<>();
		
		//명령 갯수 입력받음
		int N = Integer.parseInt(br.readLine());
		
		
		
		
		
		for (int i = 0; i < N; i++) {
			//push의 경우 명령어가 두 개로 인식될 수 있으므로
			//처음 받는 명령은 반드시 첫번째 문자열로 받아들인다
			String[] input = br.readLine().split(" ");
			String x = input[0];
			
			//주어진 명령에 따라 어떤 일을 처리할지 switch-case 구문으로 작성
			switch (x) {
				//push의 경우 2번째 문자열이 존재하므로 그걸 정수로 바꾸어 받아들인다.
				case "push": que.add(Integer.parseInt(input[1]));
					break;
					
				case "pop" : 
					
					//LinkedList의 메서드 pollFirst는
					//값이 있으면 그값을 반환하고 제거, 없으면 null을 반환하므로
					//아래와 같이 코드를 작성
					//sysout을 쓰면 시간초과 뜬다 ㅅㅂ
					//bw write
					if (que.isEmpty()) {
						bw.write(-1+"\n");
					} else {
						bw.write(que.pollFirst()+"\n");
					}
					
					break;
					
				case "size" : 
					if (que.isEmpty()) {
						bw.write(0+"\n");
					} else {
						bw.write(que.size()+"\n");
					}
					
					
					break;
					
				case "empty" :
					if (que.isEmpty()) {
						bw.write(1+"\n");
					} else {
						bw.write(0+"\n");
					}
					
					break;
					
				case "front" :
					if (que.isEmpty()) {
						bw.write(-1+"\n");
					} else {
						bw.write(que.peekFirst()+"\n");
					}
					
					break;
					
				case "back" :
					if (que.isEmpty()) {
						bw.write(-1+"\n");
					} else {
						bw.write(que.peekLast()+"\n");
					}
					
					break;
			
			
			}
			
			
		}
		
		bw.flush();
		bw.close();
		
		
	}

}
