import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	//병합정렬을 이용한 구현
	public static void main(String[] args) throws IOException {
		//입력되는 숫자의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());		
		int[] arr = new int[N];
		sortedArr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(arr, 0, N-1);
		for (int i : arr) {
			bw.write(i+"\n");
		}
		
		bw.flush();
		bw.close();
		
		
		
		
	}
	
	// 분할과정 / 병합과정으로 분리
	public static void mergeSort(int[] arr, int L, int R) {
		
		//최소단위가 될 때까지 우선 분할한다.
		//L = R이 되는 순간 멈추게 되고
		//이 때는 원소 한개씩으로 쪼개질 때이다. 
		if (L < R) {
			//중앙
			int mid = (L+R)/2;
			//좌분할
			mergeSort(arr, L, mid);
			//우분할
			mergeSort(arr, mid+1, R);
			//쪼개진 것들을 합치는 과정
			//좌분할부터 진행하기때문에
			//시스템스택에 의하여 전위순회처럼 가장 왼쪽 
			//부분집합들부터 합쳐진다.
			merge(arr, L, mid, R);
		}
		
		
	}
	
	static int[] sortedArr;
	
	public static void merge(int[] arr, int left, int mid, int right) {
		//쪼개진
		int L = left;
		int R = mid+1;
		int idx = left;
		//다른 방식으로도 범위조건을 줄 수도 있지만
		//이게 가장 가독성이 좋다.
		while (L <= mid && R <= right) {
			//같을때는 바꾸지 않아야 안정정렬이 유지된다.
			//오름차순으로 만들거기때문에
			//정렬이 완료되는 놈은 작은 놈이 정렬이 완료된 놈이다!
			if (arr[L] > arr[R]) {
				//정렬된 배열에 넣은놈은 빼야한다(R++)
				sortedArr[idx++] = arr[R++];
			} else {
				sortedArr[idx++] = arr[L++];
			}	
		}
		
		//비교를 통한 쪼개진 두 집합의 순서정렬이 끝났다면
		//나머지 원소들을 모두 넣어준다.
		if (R > right) {
			for (int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		} else if (L > mid) {
			for (int i = R; i <= right; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
//		System.out.println(Arrays.toString(sortedArr));
		//정렬된 정보를 원래 arr에 넘겨주어야한다.
		//왜냐하면 앞선 순서에서 정렬됐다는 가정하에 
		//병합과정에서의 정렬이 제대로 이루어지기 때문이다.
		for (int i = left; i <= right; i++) {
			arr[i] = sortedArr[i];
		}
		
		
	}
	

}
