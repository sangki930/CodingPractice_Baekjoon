package BOJ.dfs.서울의지하철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static HashMap<Integer,List<Integer>> numberLineMap = new HashMap();
	static List<Integer>[] lineReach = new List[11];
	static int n,k;
	static Queue<Integer> q = new ArrayDeque<>();
	static boolean[] visit = new boolean[11];
	
	public static void main(String[] args) throws IOException {
		System.out.println(solve());
	}
	
	static int solve() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			lineReach[i] = new ArrayList<Integer>();
			//
			for(int j=0;j<k;j++) {
				int curnum = Integer.parseInt(st.nextToken());
				numberLineMap.putIfAbsent(curnum, new ArrayList<Integer>());
				numberLineMap.get(curnum).add(i);
				lineReach[i].add(curnum);
			}

			
		}
		
		int dest = Integer.parseInt(br.readLine());
		int start = 0;

		for(int nxtLine : numberLineMap.get(start)) {
			q.add(nxtLine); q.add(0);
			visit[nxtLine] = true;
		}
		while(!q.isEmpty()) {
			int curLine = q.poll();
			int dist = q.poll();
			if(lineReach[curLine].contains(dest)) {
				return dist;
			}
			
			for(int nxtNum : lineReach[curLine]) {
				for(int nxtLine : numberLineMap.get(nxtNum)) {
					if(visit[nxtLine]) continue;
					q.add(nxtLine); q.add(dist+1);
					visit[nxtLine] = true;
				}
			}
		}
		
		return -1;
	}
}