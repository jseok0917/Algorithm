package BOJ_1715_카드셔플;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class Main3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> cardsList = new TreeMap<>();
		
		
		
		//설계 아이디어:
		//Map과 DP를 활용
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (cardsList.containsKey(num)) {
				cardsList.put(num, cardsList.get(num)+1);
			} else {
				cardsList.put(num, 1);
			}
		}
		
		System.out.println(cardsList.toString());
		System.out.println(cardsList.keySet());
		
		for (int i : cardsList.keySet()) {
			System.out.println(i);
			cardsList.put(555, 3);
		}
		
		
		
	
	}

}
