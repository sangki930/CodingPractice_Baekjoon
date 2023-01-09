package BOJ.graph.거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		
		Map<Integer,ArrayList<Integer>> parties = new HashMap<>();
		Map<Integer,ArrayList<Integer>> participate = new HashMap<>();
		List<Integer> acquired = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toList());
		acquired.remove(0); // 불필요한 부분 제거
		for(int i=0;i<m;i++) {
			input = br.readLine().split(" ");
			int cnt = Integer.parseInt(input[0]);
			ArrayList<Integer> tmp = parties.getOrDefault(i, new ArrayList<>());
			for(int j=1;j<=cnt;j++) {
				int v = Integer.parseInt(input[j]);
				tmp.add(v);
				ArrayList<Integer> tmp1 = participate.getOrDefault(v, new ArrayList<>());
				tmp1.add(i);
				participate.put(v, tmp1);
			}
			parties.put(i, tmp);
		}
		
		boolean[] visited = new boolean[n+1];
		visited[0] = true;
		
		while(!acquired.isEmpty()) {
			int p = acquired.remove(0);
			if(visited[p]) continue;
			visited[p] = true;
			ArrayList<Integer> tmp1 = participate.getOrDefault(p, new ArrayList<>());
			for(int party : tmp1) {
				ArrayList<Integer> tmp2 = parties.getOrDefault(party, new ArrayList<>());
				for(int participant : tmp2) {
					if(!visited[participant]) {
						acquired.add(participant);
					}
				}
			}
		}
		int answer = 0;
		for(int key : parties.keySet()) {
			ArrayList<Integer> tmp = parties.get(key);
			boolean flag = true;
			for(int i : tmp)
				if(visited[i]) {
					flag = false;
					break;
				}
			if(flag) answer++;
		}
		System.out.println(answer);
		
		br.close();
	}
}