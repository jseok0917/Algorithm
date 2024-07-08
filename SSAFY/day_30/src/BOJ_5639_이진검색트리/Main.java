package BOJ_5639_이진검색트리;

import java.io.File;
import java.util.Scanner;

public class Main {
	
	//전위순회할때는 복구가된다
	//
	static class Node {
		int root;
		Node left;
		Node right;

	}
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		File file = new File("./input.txt");
		Scanner sc = new Scanner(new File(""))
		
		boolean isLeft = false;
		boolean isRight = false;
		int cnt =0;
		while(sc.hasNextInt()) {
			sc.nextInt();
			System.out.println(++cnt);
		}
		
		System.out.println("끝");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
