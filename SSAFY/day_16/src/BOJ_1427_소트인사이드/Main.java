package BOJ_1427_소트인사이드;

public class Main {
	//퀵정렬을 이용한 구현
	public static void main(String[] args) {
		
		System.out.println((int) (Math.random()*3));
		
	}
	
	public static void quickSort(int[] arr, int L, int R) {
		if (L < R) {
			
			//분할과정을 통해 pivot값(고른 숫자의 index값)을 return하여
			//왼쪽 오른쪽으로 크기를 나누어 배열을 분할한 후
			int pivot = partition(arr, L, R);
			
			//분할한 것들에 대하여 정렬과정(다시 쪼개질 것이므로 분할정복이다)
			//을 재진행한다.
			quickSort(arr, L, pivot-1);
			quickSort(arr, pivot+1, R);

		}
	}
	
	public static int partition(int[] arr, int L, int R) {
		
		
		
		return 1;
	}

}
