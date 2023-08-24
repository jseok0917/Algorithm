import java.util.Scanner;

public class Solution {
	//최대힙 구현
	static int[] heap;
	static int heapSize = 0;
	public static void heapPush(int item) {
		heap[++heapSize] = item;
		int ch = heapSize;
		int p = ch/2;
		
		//자식이 부모보다 크면 교환
		while (p > 0 && heap[ch] > heap[p]) {
			int tmp = heap[ch];
			heap[ch] = heap[p];
			heap[p] = tmp;
			
			ch = p;
			p = ch/2;
			
		}
	}
	
	//root노드를 제거하고 반환
	public static int heapPop() {
		//공백이면 -1을 반환한다
		if (heapSize == 0) {
			return -1;
		}
		
		int item = heap[1];
		//마지막원소가 tmp
		int tmp = heap[heapSize--];
		heap[1] = tmp;
		
		//힙을 정렬해주는 과정을 추가한다
		
		//만약에 p의 자식이 존재하고,
		//자식이 부모보다 크면 바꿔야하는데
		//두 개의 자식 중에서 더 큰 걸로 바꿔줘야 최대힙의 성질을
		//여전히 유지하므로
		
		//이건 완전 이진트리이므로 
		int p = 1;
		
		//왼쪽 자식이 존재한다면  아래와 같은 과정을 진행한다.
		int ch = 2 * p;
		
		
		//오른쪽 자식이 존재하고, 왼쪽자식보다 크면 바꿀 것으로 오른쪽 자식을 선택한다.
		if (ch+1 <= heapSize && heap[ch+1] > heap[ch]) {
			ch = ch+1;
		}
		
		//자식이 힙의 사이즈를 넘지 않고
		//자식의 크기가 부모의 크기보다 클 때마다 교환한다.
		//뺄때도 여전히 힙이 되도록 한다.
		while (ch <= heapSize && heap[ch] > heap[p]) {
			//이렇게 바꿔주고
			tmp = heap[ch];
			heap[ch] = heap[p];
			heap[p] = tmp;
			
			//부모를 자식으로 변경하여 다시 반복시킨다.
			p = ch;
			ch = 2 * p;
			if (ch+1 <= heapSize && heap[ch + 1] > heap[ch]) {
				ch = ch + 1;
			}
		}
		
		
		

		return  item;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스 입력
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			heapSize = 0;
			//연산개수 입력
			int N = sc.nextInt();
			
			//노드의 갯수는 주어진 연산의 갯수보다 작거나 같을 것이므로
			heap = new int[2*N+1];
			//마지막에 출력을 모아줄 Stringbuilder 선언
			
			System.out.printf("#%d ",tc);
			for (int i = 0; i < N; i++) {
				//연산의 종류를 입력받고
				//종류에 따라 다르게 적용
				int operation = sc.nextInt();
				switch (operation) {
					case 1 : heapPush(sc.nextInt());
						break;
					case 2 : System.out.print(heapPop()+" ");
						break;
				}
			}
			System.out.println();

			
		}
		
		
		
		
	}

}
