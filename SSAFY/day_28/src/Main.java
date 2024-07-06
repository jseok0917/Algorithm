import java.util.*;
import java.io.*;

class Shark {
	int r;
	int c;
	int s;
	int d;
	int z;

	@Override
	public String toString() {
		return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
//		return "Shark [s=" + s + ", d=" + d + ", z=" + z + "]";

	}

	public Shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c;
		result = prime * result + d;
		result = prime * result + r;
		result = prime * result + s;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shark other = (Shark) obj;
		if (c != other.c)
			return false;
		if (d != other.d)
			return false;
		if (r != other.r)
			return false;
		if (s != other.s)
			return false;
		if (z != other.z)
			return false;
		return true;
	}

}

public class Main {
	// 1 2 3 4
	// 위 아래 오른쪽 왼쪽
	private static final int[][] direction = { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	private static int r;
	private static int c;
	private static int m;
	private static List<Shark> sharks;

	public static void main(String[] args) throws IOException {
		init();
		int sharkWeight = findAnswer();
		System.out.println(sharkWeight);
	}

	/// 초기화 메서드
	private static void init() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		r = Integer.parseInt(tokenizer.nextToken());
		c = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());

		sharks = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			tokenizer = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());
			int s = Integer.parseInt(tokenizer.nextToken());
			int d = Integer.parseInt(tokenizer.nextToken());
			int z = Integer.parseInt(tokenizer.nextToken());
			sharks.add(new Shark(r, c, s, d, z));
		}
	}

	// 잡은 상어의 무게 return
	private static int findAnswer() {
		int weightSum = 0;

		for (int i = 1; i <= c; i++) {
			/// 이동하고 상어 잡고
			weightSum += catchShark(i);
			/// 상어 이동
			sharksMoving();
		}

		return weightSum;
	}

	private static int catchShark(int fishmanCol) {
		Shark catched = null;
		Shark[] map = new Shark[r + 1];
		int w = 0;

		for (Shark s : sharks) {
			if (s.c == fishmanCol) {
				map[s.r] = s;
			}
		}

		for (int i = 1; i <= r; i++) {
			if (map[i] != null) {
				catched = map[i];
				w = catched.z;
				break;
			}
		}

		if (catched != null) {
			sharks.remove(catched);
		}

		return w;
	}

	/// 상어들이 각자 가지고 있는 속도와 방향으로 이동
	private static void sharksMoving() {
//		System.out.println();
		for (Shark s : sharks) {
			sharkMove(s);
		}
		// 같은 위치에 상어가 두마리 이상인 경우 큰 놈이 작은 놈 먹음
		eatSamePosition();
	}

	private static void sharkMove(Shark s) {
		int mod = s.s;
		
//		System.out.println("start : " + s);
		
		if(s.d == 1 || s.d == 2) {
			mod %= (2 * (r - 1));
		} 
		
		if(s.d == 2 || s.d == 3) {
			mod %= (2 * (c - 1));
		}
		
		for (int i = 1; i <= mod; i++) {
			int nextR = s.r + direction[s.d][0];
			int nextC = s.c + direction[s.d][1];
			/// 벽에 도착해 더이상 기존 방향으로 갈 수 없는 경우 방향을 반대로 전환
			if (!isInRange(nextR, nextC)) {
				chageDirection(s);
			}
			nextR = s.r + direction[s.d][0];
			nextC = s.c + direction[s.d][1];

			s.r = nextR;
			s.c = nextC;
		}

//		System.out.println("end : " + s);

	}

	private static void chageDirection(Shark s) {
		if (s.d == 1) {
			s.d = 2;
			return;
		}

		if (s.d == 2) {
			s.d = 1;
			return;
		}

		if (s.d == 3) {
			s.d = 4;
			return;
		}

		if (s.d == 4) {
			s.d = 3;
		}
	}

	private static boolean isInRange(int row, int col) {
		return 1 <= row && row <= r && 1 <= col && col <= c;
	}

	/// 이동이 끝나고 같은 위치에 있는 상어 제거
	private static void eatSamePosition() {
		Set<Shark> removeList = new HashSet<>();

		for (int i = 0; i < sharks.size() - 1; i++) {
			Shark a = sharks.get(i);
			for (int j = i + 1; j < sharks.size(); j++) {
				Shark b = sharks.get(j);

				if (isSameLocation(a, b)) {
					if (a.z > b.z) {
						removeList.add(b);
						continue;
					}

					if (a.z < b.z) {
						removeList.add(a);
					}
				}
			}
		}

		sharks.removeAll(removeList);
	}

	/// 비교하는 상어가 같은 위치에 있을 때
	private static boolean isSameLocation(Shark a, Shark b) {
		return a.r == b.r && a.c == b.c;
	}
}