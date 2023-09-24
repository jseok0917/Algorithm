import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//정점의 수, 간선의 개수
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		//크루스칼 알고리즘을 이용한다.
		//간선배열을 이용한다.
		ArrayList<Edge> edgeArr = new ArrayList<>();
		
		//입력은 간선배열로
		for (int i = 0; i < E; i++) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(input.nextToken());
			int to = Integer.parseInt(input.nextToken());
			int W = Integer.parseInt(input.nextToken());
			
			edgeArr.add(new Edge(from, to, W));
		}
		
		//가중치가 작은 순으로 퀵정렬
		Collections.sort(edgeArr, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.weight - o2.weight;
			}
			
		});
		
		p = new int[V+1];
		visited = new boolean[E];
		makeset();
		
		//가중치의 합을 구하기 위한
		int sum = 0;
		
		//정점이 V개 이므로
		//간선은 V-1개 택하면 끝
		for (int i = 0; i < V-1; i++) {
			
			for (int j = 0; j < E; j++) {
				if (visited[j]) {
					continue;
				} else {
					Edge edge = edgeArr.get(j);
					int x = edge.from;
					int y = edge.to;
					int W = edge.weight;
					int px = findset(x);
					int py = findset(y);
					if (px == py) {
						continue;
					} else {
						union(px, py);
						sum += W;
						visited[j] = true;
						break;
					}
				}
			}
			
			
		}
		
		System.out.println(sum);
		
		
		
		
		
		
	}
	//병합정렬 구현할까 말까
	
	static boolean[] visited;
	static int[] p;
	static int V, E;
	
	//유니온-파인드 구현
	static void makeset() {
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
	}
	
	//조회시 자동으로 바뀌도록
	static int findset(int x) {
		if (x != p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}
	
	//y의 대표자의 대표자를 x의 대표자로
	static void union(int px, int py) {
		p[py] = px;
	}
	

}
