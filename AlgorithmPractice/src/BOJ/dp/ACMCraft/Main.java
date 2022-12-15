package BOJ.dp.ACMCraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<t;i++) {
//			System.out.println("==========================");
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]), k = Integer.parseInt(tmp[1]);
			int[] d = new int[n+1];
			tmp = br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				d[j] = Integer.parseInt(tmp[j-1]);
			}
			
			Map<Integer,ArrayList<Integer>> map = new HashMap<>();
			int[] degree = new int[n+1];
			for(int j=0;j<k;j++) {
				tmp = br.readLine().split(" ");
				int a = Integer.parseInt(tmp[0]), b = Integer.parseInt(tmp[1]);
				ArrayList<Integer> arr = map.getOrDefault(a, new ArrayList<>());
				arr.add(b);
				map.put(a, arr);
				degree[b]++;
			}
//			System.out.println(map);
			
			int w = Integer.parseInt(br.readLine());
			LinkedList<Integer> queue = new LinkedList<>();
			int[] time = new int[n+1];
//			Arrays.fill(time,-1);
			for(int j=1;j<=n;j++) {
				if(degree[j]==0) {
					queue.offer(j);
					time[j] = d[j];
				}
			}
			
			int answer = Integer.MAX_VALUE;
			while(!queue.isEmpty()) {
				int p = queue.poll();
				ArrayList<Integer> arr = map.getOrDefault(p, new ArrayList<>());
				for(int s : arr) {
					degree[s]--;
					time[s] = Math.max(time[p]+d[s], time[s]);
					if(degree[s]==0) {
						queue.offer(s);
					}
				}
			}
//			System.out.println(Arrays.toString(time));
			answer = time[w];
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}

}
