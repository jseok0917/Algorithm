package BOJ_4195_친구네트워크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	//각 사람의 대표자를 저장해놓는 map
	static HashMap<String, String> parent;
	
	//각 그룹의 인원수를 나타내는
	static HashMap<String, Integer> number;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			
			parent = new HashMap<>();
			number = new HashMap<>();
			
			//친구 관계의 수 F
			int F = Integer.parseInt(br.readLine());
			for (int i = 0; i < F; i++) {
				String[] input = br.readLine().split(" ");
				
				//x와 y는 친구 관계이다.
				String x = input[0];
				String y = input[1];
				
				//x와 y가 부모배열에 입력이 돼있지 않을 경우
				//초기값을 할당해놓는다.
				if (!parent.containsKey(x)) {
					parent.put(x, x);
					number.put(x, 1);
				}
				
				if (!parent.containsKey(y)) {
					parent.put(y, y);
					number.put(y, 1);
				}
				
				String px = findset(x);
				String py = findset(y);
				
				union(px, py);
				
				if (px.compareTo(py) < 0) {
					sb.append(number.get(px)+"\n");
				} else {
					sb.append(number.get(py)+"\n");
				}
				
			}
			
			
			
		}
		
		System.out.println(sb.toString());
		
		
		
		
	}
	
	//x와 y의 대표자를 같게 만드는 메서드
	static void union(String x, String y) {
		
		String px = findset(x);
		String py = findset(y);
		
		//사전식 순서에서 앞에 오는 놈을 
		//우선순위가 더 큰 놈으로 생각한다.
		if (x.compareTo(y) < 0) {
			parent.put(y, px);
			//숫자 합계도 적어놓는다.
			if (!px.equals(py)) {
			number.put(x, number.get(x)+number.get(y));
			}
		} else {
			parent.put(x, py);
			if (!px.equals(py)) {
			number.put(y, number.get(x)+number.get(y));
			}
		}
		
		
	}
	
	//x가 속해있는 집단의 대표자를 찾는 메서드
	//자신의 부모가 자기자신이면 자신이 대표자다
	static String findset(String x) {
		
		String px = parent.get(x);
		
		//대표자면 return
		if (x.equals(px)) {
			return x;
		}
		
		//아닐 경우
		//자신의 대표자를 부모의 대표자로 바꾼다.
		parent.put(x, parent.get(px));
		
		return findset(px);
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
