package BOJ.tree.Æ®¸®;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		Map<Integer,ArrayList<Integer>> tree = new HashMap<>();
		int start=0;
		for(int i=0;i<n;i++) {
			int p = Integer.parseInt(input[i]), s = i;
			ArrayList<Integer> arr = tree.getOrDefault(p, new ArrayList<>());
			arr.add(s);
			tree.put(p, arr);
		}
		int del = Integer.parseInt(br.readLine());
		System.out.println(dfs(start,del,tree));
		br.close();
	}
	
	public static int dfs(int start,int del,Map<Integer,ArrayList<Integer>> tree) {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int cnt=0;
		while(!stack.isEmpty()) {
			int node = stack.pop();
			ArrayList<Integer> arr = tree.getOrDefault(node, new ArrayList<>());
			boolean isPush = false;
			for(int s : arr) {
				if(s==del) continue;
				stack.push(s);
				isPush=true;
			}
			
			if(arr.isEmpty() || (!isPush && node!=-1)) {
				cnt++;
			}
		}
		
		return cnt;
	}

}
