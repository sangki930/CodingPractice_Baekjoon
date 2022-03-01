package BOJ.dfs.DFS와_BFS;

import java.util.*;

public class Main{
	
	static int map[][];
	static boolean[] visit;
	static ArrayList<TreeMap<Integer,Integer>> arrayList;
	static int n,m,v;
	
	public static void dfs(int i) {
		visit[i] = true;
		System.out.print(i+" ");
		TreeMap<Integer,Integer> tmp = arrayList.get(i);
		for(int j: tmp.keySet()) {
			if(visit[j]==false) {
				dfs(j);
			}
			
		}
		
	}
	
	public static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(i);
		visit[i] = true;
		//방문했다는 것을 표시
		while(!queue.isEmpty()) {
			
			int temp = queue.poll();
			//첫 번째 방문한 위치는 빼주기로 한다.
			System.out.print(temp + " ");
			
			for(int k=1;k<=n;k++) {
				if(map[temp][k]==1 && visit[k]==false) {
					queue.offer(k);
					visit[k] = true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringTokenizer st = new StringTokenizer(s," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		v=Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		arrayList  = new ArrayList<>();
		for(int j=0;j<n+1;j++) {
			Arrays.fill(map[j], 0);
			arrayList.add(new TreeMap<Integer,Integer>());
		}
		Arrays.fill(visit, false);//방문노드를 false로 채움
		
		for(int i=0;i<m;i++) {
			String edge = sc.nextLine(); 
			StringTokenizer st1 = new StringTokenizer(edge," "); 
			int a = Integer.parseInt(st1.nextToken()); 
			int b = Integer.parseInt(st1.nextToken()); 
			map[a][b]=1; 
			map[b][a]=1; 
			arrayList.get(a).put(b, a); 
			arrayList.get(b).put(a, b);

		}
		
		dfs(v);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(v);
		
	}
	
	
}