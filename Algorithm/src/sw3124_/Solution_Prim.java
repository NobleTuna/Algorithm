package sw3124_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution_Prim {
	static long result;
	static boolean[] visited;
	static ArrayList<Vertex>[] vertexList;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String[] ve = br.readLine().split(" ");
			int V = Integer.parseInt(ve[0]); // 정점의 갯수
			int E = Integer.parseInt(ve[1]); // 간선의 갯수
			
			//각 정점은 하나씩의 ArrayList를 가지고, 거기에 자신과 연결된 정점과 비용정보를 저장할거임
			//정점번호가 0~V-1이 아니라 1~V 니까
			vertexList = new ArrayList[V+1];
			visited  = new boolean[V+1];
			for(int i = 1; i < V+1; i++) {
				vertexList[i] = new ArrayList<>();
			}
			//E개의 간선정보 입력받기
			for(int i = 0; i < E; i++) {
				String[] abc = br.readLine().split(" ");
				int a = Integer.parseInt(abc[0]);
				int b = Integer.parseInt(abc[1]);
				int c = Integer.parseInt(abc[2]);
				
				//a b c 라는건, 
				//a정점에서 b정점으로 이동하는데 c비용이 소요
				//b정점에서 a정점으로 이동하는데 c비용이 소요
				vertexList[a].add(new Vertex(b, c));
				vertexList[b].add(new Vertex(a, c));
			}
			
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			//1번을 시작정점으로 잡음.	
			visited[1] = true;
			for(Vertex v : vertexList[1])
				pq.add(v);
			
			int cnt = 0;
			//MST의 가중치를 저장할 변수.
			result = 0;
			while(! pq.isEmpty()) {
				if(cnt == V)
					break;
				
				Vertex vertex = pq.poll();
				if( visited[vertex.v])
					continue;
				
				cnt++;
				result += vertex.cost;
				visited[vertex.v] = true;
				for(Vertex v : vertexList[vertex.v])
					pq.add(v);
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int v;
		long cost;
		public Vertex(int v, long cost) {
			this.v = v;
			this.cost = cost;
		}
		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.cost < o.cost?-1:1;
		}
		
	}
}















