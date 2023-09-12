import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		states = new ArrayList<>();
		initState = new int[] {A, B, C};
		//처음 물의 상태는 아래와 같다.
		int[] state = {0, 0, C};
//		System.out.println(Arrays.toString(insert(2, 0, state)));
		
		
		searchState(state);
		TreeSet<Integer> checkC = new TreeSet<>();
		
		for (int[] i : states) {
			//첫번째 물통이 비어있을 때 가능한 C물통의 양만 
			if (i[0] == 0) {
				checkC.add(i[2]);
			}
		}
		
		for (int i : checkC) {
			System.out.print(i+" ");
		}
		
		
	}
	
	//물통의 용량
	static int A;
	static int B;
	static int C;
	
	//용량값 배열로 저장
	static int[] initState;
	
	static ArrayList<int[]> states;

	//0번 인덱스 : A
	//1번 인덱스 : B
	//2번 인덱스 : C
	public static void searchState(int[] state) {
		//null값이 넘어왔다면(insert가 불가능한 상황)
		//재귀를 종료한다.
		if (state == null) {
			return;
		}
		
		//등록여부 확인
		boolean isRegistered = false;
		int N = states.size();
	f1:	for (int i = 0; i < N; i++) {
			int[] tmp = states.get(i);
			for (int j = 0; j < 3; j++) {
				if (tmp[j] != state[j]) {
					continue f1;
				}
				
			}
			
			isRegistered = true;
		}
		
		//이미 등록한 상태이면 재귀 종료
		if (isRegistered) {
			return;
		} else {
		//등록한 상태가 아니면 현재 state를 저장한다.
			states.add(state);

			//순열로 완전 탐색(현재 상태로부터 넣는 모든 경우의 수를 탐색한다.)
			for (int i = 0; i < 3; i++) {
				for (int j = i+1; j < 3; j++) {
					//깊은 복사 후에 재귀를 돌려버리기
					int[] temp = new int[3];
					int[] temp2 = new int[3];
					for (int k = 0; k < 3; k++) {
						temp[k] = state[k];
						temp2[k] = state[k];
					}
					searchState(insert(i, j, temp));
					searchState(insert(j, i, temp2));
				}
			}
			
			

		}
		
	}
	
	//0번째 : A, 1번째 : B, 2번째 : C
	//i번째의 물을 j번째물통에 넣는다
	public static int[] insert(int i, int j, int[] state) {
		//i,j 물통의 현재 용량
		int I = state[i];
		int J = state[j];
		//i,j 물통의 전체 용량
		int totalI = initState[i];
		int totalJ = initState[j];
		
		//i번째 물통에 물이 남아있다면
		if (I != 0) {
			//j번째 물통에 물이 꽉차있지 않다면
			if (J != totalJ) {
				//j번째 물통에 더 채워놓을 수 있는 물의 양이 
				//현재 i번째 물통의 양보다 많다면
				if (totalJ-J >= I) {
					state[i] = 0;
					state[j] = J+I;
					return state;
				//i번째 물통의 물을 j번째 물통에
				//다 채워놓을 수 없다면
				} else {
					state[j] = totalJ;
					state[i] = I - (totalJ-J);
					return state;
				}
				
				
			}
			
			return null;
		}
		
		
		
		return null;
	}
	
	
}
