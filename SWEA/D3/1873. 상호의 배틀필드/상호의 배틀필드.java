import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스의 숫ㅈ사
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
		
		//맵의 높이와 너비 입력
		H = sc.nextInt();
		W = sc.nextInt();
		
		//맵을 상화좌우로 한칸 늘려서
		//맵의 테두리를 강철로 만든다.
		//맵 밖으로 벗어나든, 아니면 강철을 만나든 아무런 일도 일어나지 않기 때문이다
		map = new String[H+2][W+2];
		for (int i = 0; i <= H+1; i+= H+1) {
			for (int j = 0; j <= W+1; j++) {
				map[i][j] = "#";
			}
		}
		
		for (int j = 0; j <= W+1; j+= W+1) {
			for (int i = 0; i <= H+1; i++) {
				map[i][j] = "#";
			}
		}
		
		
		//맵 현재상태 입력
		for (int i = 1; i <= H; i++) {
			String[] input = sc.next().split("");
			for (int j = 1; j <= W; j++) {
				map[i][j] = input[j-1];
				//포탄을 찾으면 포탄의 현재 위치와 방향 입력
				if (map[i][j].equals("<") || map[i][j].equals(">") || map[i][j].equals("v") || map[i][j].equals("^")) {
					m = i;
					n = j;
					d = map[i][j];
					
				}
			}
		}
		
		//명령의 숫자 입력
		int N = sc.nextInt();
		
		
//		command("S");
//		System.out.println("============구분선===========");
//		for (String[] i : map) {
//			System.out.println(Arrays.toString(i));
//		}
		
		//명령어를 받는다
		String[] commands = sc.next().split("");
		for (int i = 0; i < N; i++) {
			command(commands[i]);
		}
		
		System.out.print("#"+tc+" ");
		for (int i = 1; i <= H; i++) { 
			for (int j = 1; j <= W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		
		
		
		}
	}
	static int H;
	static int W;
	
	//전차의 현재 위치와 방향을 나타내는 변수 선언
	static int m;
	static int n;
	static String d;
	//상하좌우 구현을 위한 배열 선언
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static String[][] map = new String[H+2][W+2];
	
	//동작 메서드 구현
	public static void command(String input) {
		if (input.equals("U")) {
			d = "^";
			map[m][n] = d;
			if (map[m+dr[0]][n+dc[0]].equals(".")) {
				map[m][n] = ".";
				m = m+dr[0];
				n = n+dc[0];
				map[m][n] = d;
			}
			
		} else if (input.equals("D")) {
			d = "v";
			map[m][n] = d;
			if (map[m+dr[1]][n+dc[1]].equals(".")) {
				map[m][n] = ".";
				m = m+dr[1];
				n = n+dc[1];
				map[m][n] = d;
			}
			
		} else if (input.equals("L")) {
			d = "<";
			map[m][n] = d;
			if (map[m+dr[2]][n+dc[2]].equals(".")) {
				map[m][n] = ".";
				m = m+dr[2];
				n = n+dc[2];
				map[m][n] = d;
			}
			
		} else if (input.equals("R")) {
			d = ">";
			map[m][n] = d;
			if (map[m+dr[3]][n+dc[3]].equals(".")) {
				map[m][n] = ".";
				m = m+dr[3];
				n = n+dc[3];
				map[m][n] = d;
			}
			
		} else if (input.equals("S")) {
			shoot(m, n, d);
			
		}
		
	}
	//체크 메서드 구현
	public static String check(int m, int n, String d) {
		//이동할 위치의 map의 상태를 반환해준다.
		if (d.equals("^")) {
			return map[m+dr[0]][n+dc[0]];
		} else if (d.equals("v")) {
			return map[m+dr[1]][n+dc[1]];
		} else if (d.equals("<")) {
			return map[m+dr[2]][n+dc[2]];
		} else {
			return map[m+dr[3]][n+dc[3]];
		} 
		
	}
	
	public static int moveInt(String d) {
		if (d.equals("^")) {
			return 0;
		} else if (d.equals("v")) {
			return 1;
		} else if (d.equals("<")) {
			return 2;
		} else {
			return 3;
		} 
	}
	
	//포탄 발사 시 메서드 구현
	//(m,n)의 위치에서 쏜다고 생각한다.
	public static void shoot(int m, int n, String d) {
		//발사 시에는 d의 방향으로 날아간다.
		//d방향으로 1칸 이동 후
		//평지면 다시 shoot
		//강철에 부딪히거나 벽에 부딪히면 재귀를 종료한다.
		//날아갈 곳이 평지나 물이라면 포탄을 한칸 이동 후 다시 쏴준다
		
		if (check(m, n, d).equals(".") || check(m, n, d).equals("-")) {
			shoot(m+dr[moveInt(d)], n+dc[moveInt(d)], d);
		} else if (check(m, n, d).equals("*")) {
		//벽돌을 만나면 날아갈 곳을 평지로 만들고 재귀함수 종료
			map[m+dr[moveInt(d)]][n+dc[moveInt(d)]] = ".";
			return;
		} else if (check(m, n, d).equals("#")) {
		//강철을 만나면 그냥 소멸
			return;
		}
		
		
		
	}


}
