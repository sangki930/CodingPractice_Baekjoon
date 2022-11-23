package BOJ.graph.노드사이의_거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Edge{
	int e;
	int dis;
	public Edge(int e, int dis) {
		this.e = e;
		this.dis = dis;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		Map<Integer,ArrayList<Edge>> graph = new HashMap<>();
		
		for(int i=0;i<n-1;i++) {
			input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]), e = Integer.parseInt(input[1]);
			int dis = Integer.parseInt(input[2]);
			ArrayList<Edge> arr_s = graph.getOrDefault(s, new ArrayList<>());
			ArrayList<Edge> arr_e = graph.getOrDefault(e, new ArrayList<>());
			arr_s.add(new Edge(e,dis));
			arr_e.add(new Edge(s,dis));
			graph.put(s, arr_s);
			graph.put(e, arr_e);
		}
		
		for(int i=0;i<m;i++) {
			input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]), e = Integer.parseInt(input[1]);
			boolean[] visited = new boolean[n+1];
			visited[0] = true;
			visited[s] = true;
			
			Stack<Edge> stack = new Stack<>();
//			stack.add(s);
			stack.push(new Edge(s,0));
			while(!stack.isEmpty()) {
//				int node = stack.pop();
				Edge edge = stack.pop();
				if(edge.e==e) {
					System.out.println(edge.dis);
					break;
				}
				ArrayList<Edge> list = graph.getOrDefault(edge.e, new ArrayList<>());
				for(Edge next : list) {
					if(!visited[next.e]) {
						stack.push(new Edge(next.e,next.dis+edge.dis));
						visited[edge.e] = true;
					}
				}
			}
			
		}
		
		br.close();
	}

}
