package BOJ_20056_마법사상어와파이어볼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		//격자의 크기 입력
		N = Integer.parseInt(input[0]);
		//파이어볼의 개수 입력
		int M = Integer.parseInt(input[1]);
		//명령의 개수 입력
		int K = Integer.parseInt(input[2]);
		
		//파이어볼을 담을 격자 생성
		lattice = new int[N][N];
		int cnt = 0;
		//격 격자점에 0 ~ (N*N-1)까지의 숫자를 인덱싱 해놓는다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				lattice[i][j] = cnt++;
			}
		}
		
		latticeInfo = new HashMap<>();
		//각 격자점에 인덱싱 돼있는 숫자들을 Map을 통하여 파이어볼들을 담을 ArrayList와 연결해놓는다.
		for (int i = 0; i < N*N; i++) {
			latticeInfo.put(i, new ArrayList<ArrayList<Integer>>());
		}
		
		//파이어볼의 정보 입력
		for (int i = 0; i < M; i++) {
			String[] info = br.readLine().split(" ");
			//행 - 열 - 질량 - 속력 - 방향 순으로 정보를 넣는다.
			//첫 입력에는 같은 위치에 두 개 이상의 파이어볼이 존재하지 않는다.
			int r = Integer.parseInt(info[0]);
			int c = Integer.parseInt(info[1]);
			int m = Integer.parseInt(info[2]);
			int s = Integer.parseInt(info[3]);
			int d = Integer.parseInt(info[4]);
			ArrayList<Integer> tmp = new ArrayList<>();
			tmp.add(m);
			tmp.add(s);
			tmp.add(d);
			
			latticeInfo.get(lattice[r-1][c-1]).add(tmp);
		}
		
		for (int k = 0; k < K; k++) {
			moveFireBall();
			afterMove();
		}
		
		int sum = 0;
		for (int i = 0; i < N*N; i++) {
			if (latticeInfo.get(i) != null) {
				int S = latticeInfo.get(i).size();
				for (int j = 0; j < S; j++) {
					sum += latticeInfo.get(i).get(j).get(0);
				}
			}
		}
		
		System.out.println(sum);
		
		
		
		
	}
	
	static int[][] lattice;
	static int N;
	static Map<Integer, ArrayList<ArrayList<Integer>>> latticeInfo = new HashMap<>();
	static Map<Integer, ArrayList<ArrayList<Integer>>> temp = new HashMap<>();
	
	//8등분 방향표현
	//0번부터 ~ 7번까지
	//행변화
	static int[] row = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] col = {0, 1, 1, 1, 0, -1, -1, -1};
	
	
	//이동명령시 어떤일이 일어나는가?
	public static void moveFireBall() {
		//이동 후, 파이어볼을 임시 저장해줄 temp 초기화
		temp = new HashMap<>();
		for (int i = 0; i < N*N; i++) {
			temp.put(i, new ArrayList<ArrayList<Integer>>());
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				//주어진 격자점 안에 존재하는 파이어볼의 개수
				int S = latticeInfo.get(lattice[r][c]).size();
				//격자점 안의 파이어볼을 모두 불러오고, 이동시킨다.
				for (int j = 0; j < S; j++) {
					ArrayList<Integer> fireBall = latticeInfo.get(lattice[r][c]).get(j);
					//파이어볼의 위치, 질량, 속력, 방향을 불러온다.
					int m = fireBall.get(0);
					int s = fireBall.get(1);
					int d = fireBall.get(2);
					//d값에 따라서 이동방향이 달라진다.
					switch (d) {
					case 0:
						//d=row[d],col[d] 의 방향으로 s칸 만큼 이동한다.
						//이중배열 범위를 벗어났을 경우 반대쪽으로 돌아오기 위해서 나머지로 구현한다.
						temp.get(lattice[(1000*N+r+row[0]*s)%N][(1000*N+c+col[0]*s)%N]).add(fireBall);
						
						break;
					case 1:
						temp.get(lattice[(1000*N+r+row[1]*s)%N][(1000*N+c+col[1]*s)%N]).add(fireBall);
						break;
					case 2:
						temp.get(lattice[(1000*N+r+row[2]*s)%N][(1000*N+c+col[2]*s)%N]).add(fireBall);
						break;
					case 3:
						temp.get(lattice[(1000*N+r+row[3]*s)%N][(1000*N+c+col[3]*s)%N]).add(fireBall);
						break;
					case 4:
						temp.get(lattice[(1000*N+r+row[4]*s)%N][(1000*N+c+col[4]*s)%N]).add(fireBall);
						break;
					case 5:
						temp.get(lattice[(1000*N+r+row[5]*s)%N][(1000*N+c+col[5]*s)%N]).add(fireBall);
						break;
					case 6:
						temp.get(lattice[(1000*N+r+row[6]*s)%N][(1000*N+c+col[6]*s)%N]).add(fireBall);
						break;
					case 7:
						temp.get(lattice[(1000*N+r+row[7]*s)%N][(1000*N+c+col[7]*s)%N]).add(fireBall);
						break;
					
					
					}
					
				}
			}
			
		} // 여기까지 이동 완료
		//latticeInfo의 값들을 temp값들로 모두 바꿔치기 한다.
		
		for (int i = 0; i < N*N; i++) {
			latticeInfo.replace(i, temp.get(i));
		}
	}
	
	//이동 후 2개 이상의 파이어볼이 칸에 존재할 경우 일어나는 변화 구현
	public static void afterMove() {
		//각 격자에 존재하는 파이어볼들을 모두 합치고, 나누는 작업을 실시한다.
		for (int i = 0; i < N*N; i++) {
			//격자에 존재하는 파이어볼의 개수를 불러온다.
			int S = latticeInfo.get(i).size();
			
			//파이어볼의 개수가 2개 이상이라면 다음과 같은 일을 발생시킨다.
			if (S > 1) {
				int sumOfMass = 0;
				int sumOfSpeed = 0;
				boolean isEven = true;
				boolean isOdd = true;
				
				for (int j = 0; j < S; j++) {
					//격자점에 존재하는 각각의 파이어볼을 가져오고,
					ArrayList<Integer> fireBall = latticeInfo.get(i).get(j);
					//파이어볼들의 질량, 속력의 합을 구해주자.
					sumOfMass += fireBall.get(0);
					sumOfSpeed += fireBall.get(1);
					
					//4개모두 짝수이면 Odd는 false, Even은 true를 반환한다
					//4개모두 홀수이면 Odd는 true, Even은 false를 반환한다.
					//짝수 홀수가 섞여있다면 둘다 false가 반환된다.
					if (fireBall.get(2)%2 == 0) {
						isOdd = false;
					} else {
						isEven = false;
					}
				}
				//질량의 합을 5로 나눈 값이 0이 아니라면
				if (sumOfMass/5 != 0) {
					//새로운 파이어볼 4개를 만든다.
					ArrayList<Integer> FireBall1 = new ArrayList<>();
					ArrayList<Integer> FireBall2 = new ArrayList<>();
					ArrayList<Integer> FireBall3 = new ArrayList<>();
					ArrayList<Integer> FireBall4 = new ArrayList<>();
					FireBall1.add(sumOfMass/5);
					FireBall1.add(sumOfSpeed/S);
					FireBall2.add(sumOfMass/5);
					FireBall2.add(sumOfSpeed/S);
					FireBall3.add(sumOfMass/5);
					FireBall3.add(sumOfSpeed/S);
					FireBall4.add(sumOfMass/5);
					FireBall4.add(sumOfSpeed/S);
					//이게 둘 중 하나라도 true라면
					if (isOdd || isEven) {
						FireBall1.add(0);
						FireBall2.add(2);
						FireBall3.add(4);
						FireBall4.add(6);
					//둘 다 false 라면
					} else {
						FireBall1.add(1);
						FireBall2.add(3);
						FireBall3.add(5);
						FireBall4.add(7);
					}
					//격자점의 모든 파이어볼을 삭제한다.
					latticeInfo.get(i).clear();

					//격자점에 나눠진 파이어볼 4개를 넣는다
					latticeInfo.get(i).add(FireBall1);
					latticeInfo.get(i).add(FireBall2);
					latticeInfo.get(i).add(FireBall3);
					latticeInfo.get(i).add(FireBall4);
					
				} else {
					//질량이 0이라면
					//격자점의 모든 파이어볼을 삭제한다.
					latticeInfo.get(i).clear();
				}
				
				
			}
			
		}
		
		
		
		
	}


}
