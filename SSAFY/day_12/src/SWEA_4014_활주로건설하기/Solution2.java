package SWEA_4014_활주로건설하기;

import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스 개수 입력
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			//지도의 한변의 크기
			int N = sc.nextInt();
			//경사로의 크기 입력
			int X = sc.nextInt();
			
			//지도 생성
			//가로방향과 세로방향으로 X칸을 늘려준다
			int[][] map = new int[N+X][N+X];
			
			//지도 정보 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//활주로 건설 불가능 정보 입력
			boolean[][] mapAirStrip = new boolean[N+X][N+X];
			
			//기존 지도는 모두 활주로 건설 가능 지역
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mapAirStrip[i][j] = true;
				}
			}
			
			//늘려준 X칸은 모두 불가능 지역으로 생각한다.

			
			
			//활주로 총개수 카운트
			int cnt = 0;
			
			//행순회
			for (int i = 0; i < N; i++) {
				//주어진 행이 활주로가 건설 가능한지
				boolean airStrip = true;
				int j = 0;
				//순회하면서 판정한다.
			f1:	while (j < N-1) {
					int diff = map[i][j+1] - map[i][j];
					
					//가다가 높이가 낮아지는 경우
					if (diff < 0) {
						//높이차가 1이 아니면 바로 활주로 건설 불가능이다.
						if (Math.abs(diff) != 1) {
							airStrip = false;
							break;
						//높이차가 1일 경우 활주로가 건설 가능한지 판정한다.
						} else {
						//활주로가 건설될 충분한 공간이 확보 안됐거나 false
						//활주로는 j+1 ~ j+X 까지 건설되야한다.
							if (j+X >= N ) {
								airStrip = false;
								break;
							//건설될 충분한 공간이 있어도 
							//j+1~j+X까지 높이가 같지 않으면 false
							} else {
								for (int k=1; k <= X; k++) {
									if (map[i][j+1] != map[i][j+k]) {
										airStrip = false;
										break f1;
									}
									//높이가 같다고 해도
									//활주로 j+1~j+X중 하나라도 건설불가능한 공간이면 false
									if (mapAirStrip[i][j+k] == false) {
										airStrip = false;
										break f1;
									}
								}
								//이 모든 난관을 뚫었다면
								//활주로를 건설하고, 활주로 길이만큼 순회를 점프한 후 진행한다.
								
								for (int l = 1; l <= X; l++) {
									mapAirStrip[i][j+l] = false;
								}
								j += X;
								continue f1;
								
								
							}
							
						}
					//가다가 높이가 높아지는경우
					} else if (diff > 0) {
						//높이차가 1이 아니면 바로 활주로 건설 불가능이다.
						if (Math.abs(diff) != 1) {
							airStrip = false;
							break;
						//높이차가 1일 경우 활주로가 건설 가능한지 판정한다.
						} else {
						//활주로가 건설될 충분한 공간이 확보 안됐거나 false
						//활주로는 j ~ j+1-X 까지 건설되야한다.
							if (j+1-X < 0 ) {
								airStrip = false;
								break;
							//건설될 충분한 공간이 있어도 
							//j~j+1-X까지 높이가 같지 않으면 false
							} else {
								for (int k=0; k <= X-1; k++) {
									if (map[i][j] != map[i][j-k]) {
										airStrip = false;
										break f1;
									}
									//높이가 같다고 해도
									//활주로 j~j+1-X중 하나라도 건설불가능한 공간이면 false
									if (mapAirStrip[i][j-k] == false) {
										airStrip = false;
										break f1;
									} 
									
								}
								
								//이 모든 난관을 뚫었다면
								//활주로를 건설하고, 다음 칸로 넘어가고 그대로 진행.
								for (int l = 0; l < X; l++) {
									mapAirStrip[i][j-l] = false;
								}
								j++;
								continue f1;
								
							}
							
						}
						
					}
					
					
					j++;
					
				}

				
				if (airStrip) {
					cnt++;
				}
			}
			
			//다시 기존 지도를 모두 활주로 건설 가능 지역 으로 다시 변경
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mapAirStrip[i][j] = true;
				}
			}
			
			
			//열순회
			for (int j = 0; j < N; j++) {
				//주어진 열이 활주로가 건설 가능한지
				boolean airStrip = true;
				int i = 0;
				//순회하면서 판정한다.
			f2:	while (i < N-1) {
					int diff = map[i+1][j] - map[i][j];
					
					//가다가 높이가 낮아지는 경우
					if (diff < 0) {
						//높이차가 1이 아니면 바로 활주로 건설 불가능이다.
						if (Math.abs(diff) != 1) {
							airStrip = false;
							break;
						//높이차가 1일 경우 활주로가 건설 가능한지 판정한다.
						} else {
						//활주로가 건설될 충분한 공간이 확보 안됐거나 false
						//활주로는 i+1 ~ i+X 까지 건설되야한다.
							if (i+X >= N ) {
								airStrip = false;
								break;
							//건설될 충분한 공간이 있어도 
							//i+1~i+X까지 높이가 같지 않으면 false
							} else {
								for (int k=1; k <= X; k++) {
									if (map[i+1][j] != map[i+k][j]) {
										airStrip = false;
										break f2;
									}
									//높이가 같다고 해도
									//활주로 i+1~i+X중 하나라도 건설불가능한 공간이면 false
									if (mapAirStrip[i+k][j] == false) {
										airStrip = false;
										break f2;
									} 
								}
								//이 모든 난관을 뚫었다면
								//활주로를 건설하고, 활주로 길이만큼 순회를 점프한 후 진행한다.
								for (int l = 1; l <= X; l++) {
									mapAirStrip[i+l][j] = false;
								}
								i += X;
								continue f2;
								
								
							}
							
						}
					//가다가 높이가 높아지는경우
					} else if (diff > 0) {
						//높이차가 1이 아니면 바로 활주로 건설 불가능이다.
						if (Math.abs(diff) != 1) {
							airStrip = false;
							break;
						//높이차가 1일 경우 활주로가 건설 가능한지 판정한다.
						} else {
						//활주로가 건설될 충분한 공간이 확보 안됐거나 false
						//활주로는 i ~ i+1-X 까지 건설되야한다.
							if (i+1-X < 0 ) {
								airStrip = false;
								break;
							//건설될 충분한 공간이 있어도 
							//i~i+1-X까지 높이가 같지 않으면 false
							} else {
								for (int k=0; k <= X-1; k++) {
									if (map[i][j] != map[i-k][j]) {
										airStrip = false;
										break f2;
									}
									//높이가 같다고 해도
									//활주로 j~j+1-X중 하나라도 건설불가능한 공간이면 false
									if (mapAirStrip[i-k][j] == false) {
										airStrip = false;
										break f2;
									} 
									
								}
								//이 모든 난관을 뚫었다면
								//활주로를 건설하고, 다음 칸로 넘어가고 그대로 진행.
								for (int l = 0; l < X; l++) {
									mapAirStrip[i-l][j] = false;
								}
								i++;
								continue f2;
								
							}
							
						}
						
					}
					
					
					i++;
					
				}

				
				if (airStrip) {
					cnt++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
				

				
			
			
			
			
			
			
		}
		
		
	}

}
