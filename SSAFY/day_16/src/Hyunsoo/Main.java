package Hyunsoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Map<Integer, List<Integer>> area;
	static int N, R, min;
	static int[] comArr, population;
	static List<Integer> allArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // N : 마을의 수
		min = Integer.MAX_VALUE;
//            area = new int[N][];
		area = new HashMap<>();

		// 마을 인구수
		population = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			population[i] = sc.nextInt();
		}
		
		// 마을 연결 관계 저장
		for (int i = 1; i <= N; i++) {
			//연결된 구역의 숫자
			area.put(i, new ArrayList<Integer>());
			int M = sc.nextInt();
			for (int j = 0; j < M; j++) {
				area.get(i).add(sc.nextInt());
			}
		}
//		System.out.println(Arrays.toString(population));
//		
//		System.out.println(area.toString());
		


		allArr = new ArrayList<>();
		for (int a = 0, num = 1; a < N; a++) {
			allArr.add(num++);
		}

		// 총 N개의 마을이 존재하면 N/2까지만 뽑으면됌
		R = N / 2;
		for (int r = 1; r <= R; r++) {
			comArr = new int[r];
			combination(0, 0, r);
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.printf("%d\n", min);
		}

	}

//구역 나누기
	static void combination(int cnt, int start, int r) {
		if (cnt == r) {
			divideArea(comArr);
			return;
		}
		for (int i = start; i < N; i++) {
			comArr[cnt] = allArr.get(i);
			combination(cnt + 1, i + 1, r);
		}
	}

//나눴을 때 2개 구역 구하기
	static void divideArea(int[] arr) {

		List<Integer> area1 = new ArrayList<>();// 임시 1구역
		List<Integer> area2 = new ArrayList<>();// 임시 2구역
		for (int a : arr) {
			area1.add(a);
		}
		for (int a : allArr) {
			if (!area1.contains(a))
				area2.add(a);
		}

		// 2구역 모두 연결 관계 성립할 때만
		int sum = 0;
		if (bfs(area1) && bfs(area2)) {
			int sum1 = 0;
			int sum2 = 0;
			for (int a : area1) {
				sum1 += population[a];
			}

			for (int a : area2) {
				sum2 += population[a];
			}
			sum = Math.abs(sum2 - sum1);
			min = Math.min(min, sum);
		}

	}

	static boolean bfs(List<Integer> list) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		queue.add(list.get(0));
		visited[list.get(0)]=true;
		System.out.println("넣어진 리스트" +list.toString());
		System.out.println("리스트에 처음 들어가는 숫자"+list.get(0));
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			result.add(tmp);
			
			
			for (int a : area.get(tmp)) {
				// 해당 구역에 있는 지역만 queue에 추가
				if (list.contains(a) && !visited[a]) {
					queue.add(a);
					visited[a] = true;// 방문 처리
				}
			}
		}

		Collections.sort(list);
		Collections.sort(result);
		System.out.println("결과값"+result.toString());

		return list.equals(result);

	}
}