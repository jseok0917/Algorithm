import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		LinkedList<Integer> list = new LinkedList<>();
		
		//연결리스트를 통해 회전하는 큐를 구현한다.
		for (int i = 0; i < N; i++) {
			list.add(i+1);
		}
		
		String[] input2 = br.readLine().split(" ");
		int[] commands = new int[input2.length];
		
		for (int i = 0; i < commands.length; i++) {
			commands[i] = Integer.parseInt(input2[i]);
		}
		//여기까지 입력
		
		//연산카운트
		int cnt = 0;
		
		for (int i = 0; i < M; i++) {
			
			int idx = list.indexOf(commands[i]);
			int L = list.size();
			
			if (idx <= (L-1)/2) {
				//왼쪽으로 이동
				for (int j = 0; j < idx; j++) {
					//첫번째원소를 제거하고 마지막 원소에 바로 추가
					list.add(list.pollFirst());
					cnt++;
				}
				//이걸 한번 따로 쓰는 이유는 가장 앞에 있을땐 이동카운트를 세주지 않으려고
				list.pollFirst();
			} else {
				//오른쪽으로 이동
				for (int j = 0; j < L-idx; j++) {
					list.addFirst(list.pollLast());
					cnt++;
				}
				
				list.pollFirst();
			}	
		}
		
		System.out.println(cnt);
		
		
		
		
		
		
		
		
	}

}
