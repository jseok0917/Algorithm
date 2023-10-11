import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	//6가지 면을 정의(네 귀퉁이가 없는 3*3배열로 생각한다)
	//윗면은 흰색(= 0), 아랫면은 노란색(= 5), 앞면은 빨간색(= 2), 
	//뒷면은 오렌지색(= 3), 왼쪽 면은 초록색(= 4), 오른쪽 면은 파란색(= 1)이다.
	//대칭되는 면의 번호 합을 5가 되도록 지정
	static String[][] U, D, F, B, L, R;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			//테스트케이스마다 큐브 초기화
			U = new String[3][3];
			D = new String[3][3];
			F = new String[3][3];
			B = new String[3][3];
			L = new String[3][3];
			R = new String[3][3];
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					U[i][j] = "w";
					D[i][j] = "y";
					F[i][j] = "r";
					B[i][j] = "o";
					L[i][j] = "g";
					R[i][j] = "b";
				}
			}
			
			
			
			
			
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				rotate(st.nextToken());
			}
			
			for (String[] i : U) {
				for (int j = 0; j < 3; j++) {
					sb.append(i[j]);
				}
				sb.append("\n");
			}
			
			
		}
		
		System.out.print(sb.toString());
	}
	
	static void rotate(String d) {
		
		String[] tmp = new String[3];
		
		switch (d) {
		
		case "U+":
			//0행 => 2열, 2열 => 2행, 2행 => 0열, 0열 => 0행
			//R => F, F => L, L => B, B => R
			//윗면을 시계방향으로 돌린다.
			rotate(1, U);
			tmp = F[0].clone();
			F[0] = R[0].clone();
			R[0] = B[0].clone();
			B[0] = L[0].clone();
			L[0] = tmp.clone(); 
			
			break;
		case "U-":
			//윗면을 반시계방향으로 돌린다.
			rotate(0, U);
			tmp = F[0].clone();
			F[0] = L[0].clone();
			L[0] = B[0].clone();
			B[0] = R[0].clone();
			R[0] = tmp.clone();
			break;	
		case "D+":
			//아랫면을 시계방향으로 돌린다.
			rotate(1, D);
			tmp = F[2].clone();
			F[2] = L[2].clone();
			L[2] = B[2].clone();
			B[2] = R[2].clone();
			R[2] = tmp.clone();
			break;	
		case "D-":
			//아랫면을 반시계방향으로 돌린다.
			rotate(0, D);
			tmp = F[2].clone();
			F[2] = R[2].clone();
			R[2] = B[2].clone();
			B[2] = L[2].clone();
			L[2] = tmp.clone(); 
			break;
		case "F+":
			//앞면을 시계방향으로 돌린다.
			//U <= L, L <= D, D <= R,  R <= U
			rotate(1, F);
			tmp = U[2].clone();
			for (int i = 0; i < 3; i++) {
				U[2][i] = L[2-i][2];
			}
			
			for (int i = 0; i < 3; i++) {
				L[i][2] = D[2][2-i];
			}
			
			for (int i = 0; i < 3; i++) {
				D[2][2-i] = R[2-i][0];
			}
			
			for (int i = 0; i < 3; i++) {
				R[2-i][0] = tmp[2-i];
			}
			break;
		case "F-":
			//앞면을 반시계방향으로 돌린다.
			//U => L, L => D, D => R,  R => U
			rotate(0, F);
			tmp = U[2].clone();
			for (int i = 0; i < 3; i++) {
				U[2][2-i] = R[2-i][0];
			}
			
			for (int i = 0; i < 3; i++) {
				R[2-i][0] = D[2][2-i];
			}
			
			for (int i = 0; i < 3; i++) {
				D[2][2-i] = L[i][2];
			}
			
			for (int i = 0; i < 3; i++) {
				L[2-i][2] = tmp[i];
			}

			
			break;
			
		case "B+":
			//뒷면을 시계방향으로 돌린다.
			//U => L, L => D, D => R,  R => U
			rotate(1, B);
			tmp = U[0].clone();
			for (int i = 0; i < 3; i++) {
				U[0][2-i] = R[2-i][2];
			}
			
			for (int i = 0; i < 3; i++) {
				R[2-i][2] = D[0][2-i];
			}
			
			for (int i = 0; i < 3; i++) {
				D[0][2-i] = L[i][0];
			}
			
			for (int i = 0; i < 3; i++) {
				L[i][0] = tmp[2-i];
			}

			
			break;
		case "B-":
			//뒷면을 반시계방향으로 돌린다.
			//U <= L, L <= D, D <= R,  R <= U
			rotate(0, B);
			tmp = U[0].clone();
			for (int i = 0; i < 3; i++) {
				U[0][2-i] = L[i][0];
			}
			
			for (int i = 0; i < 3; i++) {
				L[i][0] = D[0][2-i];
			}
			
			for (int i = 0; i < 3; i++) {
				D[0][2-i] = R[2-i][2];
			}
			
			for (int i = 0; i < 3; i++) {
				R[2-i][2] = tmp[2-i];
			}
			break;
			
		case "L+":
			//왼쪽면을 시계방향으로 돌린다.
			//B => U, D => B, F => D, U => F
			rotate(1, L);
			for (int i = 0; i < 3; i++) {
				tmp[i] = U[i][0];
			}
			
			for (int i = 0; i < 3; i++) {
				U[i][0] = B[2-i][2];
			}
			
			for (int i = 0; i < 3; i++) {
				B[2-i][2] = D[2-i][2];
			}
			
			for (int i = 0; i < 3; i++) {
				D[2-i][2] = F[i][0];
			}
			
			for (int i = 0; i < 3; i++) {
				F[i][0] = tmp[i];
			}

			break;
			
		case "L-":
			//왼쪽면을 반시계방향으로 돌린다.
			//B <= U, D <= B, F <= D, U <= F
			rotate(0, L);
			for (int i = 0; i < 3; i++) {
				tmp[i] = U[i][0];
			}
			
			for (int i = 0; i < 3; i++) {
				U[i][0] = F[i][0];
			}
			
			for (int i = 0; i < 3; i++) {
				F[i][0] = D[2-i][2];
			}
			
			for (int i = 0; i < 3; i++) {
				D[2-i][2] = B[2-i][2];
			}
			
			for (int i = 0; i < 3; i++) {
				B[2-i][2] = tmp[i];
			}
			
			break;
			
		case "R+":
			//오른쪽면을 시계방향으로 돌린다.
			//B <= U, D <= B, F <= D, U <= F
			rotate(1, R);
			for (int i = 0; i < 3; i++) {
				tmp[i] = U[i][2];
			}
			
			for (int i = 0; i < 3; i++) {
				U[i][2] = F[i][2];
			}
			
			for (int i = 0; i < 3; i++) {
				F[i][2] = D[2-i][0];
			}
			
			for (int i = 0; i < 3; i++) {
				D[2-i][0] = B[2-i][0];
			}
			
			for (int i = 0; i < 3; i++) {
				B[2-i][0] = tmp[i];
			}
			
			break;
			
		case "R-":
			//오른쪽면을 반시계방향으로 돌린다.
			//B => U, D => B, F => D, U => F
			rotate(0, R);
			for (int i = 0; i < 3; i++) {
				tmp[i] = U[i][2];
			}
			for (int i = 0; i < 3; i++) {
				U[i][2] = B[2-i][0];
			}
			for (int i = 0; i < 3; i++) {
				B[2-i][0] = D[2-i][0];
			}
			for (int i = 0; i < 3; i++) {
				D[2-i][0] = F[i][2];
			}

			for (int i = 0; i < 3; i++) {
				F[i][2] = tmp[i];
			}
			break;

		}
		

	}
	
	//0방향은 반시계, 1방향은 시계
	static void rotate(int d, String[][] face) {
		
		String[] tmp = new String[3];
				
		//전부 깊은 복사로 진행
		switch (d) {
		case 1:
			//0행 => 2열, 2열 => 2행, 2행 => 0열, 0열 => 0행
			
			//0행을 복사
			tmp = face[0].clone();
			
			//0열 => 0행
			for (int i = 0; i < 3; i++) {
				face[0][i] = face[2-i][0];
			}
			
			//2행 => 0열
			for (int i = 0; i < 3; i++) {
				face[i][0] = face[2][i];
			}
			
			//2열 => 2행
			for (int i = 0; i < 3; i++) {
				face[2][i] = face[2-i][2];
			}
			
			//0행 => 2열
			for (int i = 0; i < 3; i++) {
				face[i][2] = tmp[i];
			}
			break;
		case 0:
			//0행 <= 2열, 2열 <= 2행, 2행 <= 0열, 0열 <= 0행
			//좌우 등호 바꿔치기&순서대로 순서바꿔주기 하면된다
			
			//0행을 복사
			tmp = face[0].clone();
			
			//0행 <= 2열
			for (int i = 0; i < 3; i++) {
				face[0][i] = face[i][2];
			}
			
			//2열 <= 2행
			for (int i = 0; i < 3; i++) {
				face[i][2] = face[2][2-i];
			}
			
			//2행 <= 0열
			for (int i = 0; i < 3; i++) {
				face[2][2-i] = face[2-i][0];
			}
			
			//0열 <= 0행
			for (int i = 0; i < 3; i++) {
				face[2-i][0] = tmp[i];
			}
			
			break;
			
		
		}
		
		
	}
	
	
	
	
}
