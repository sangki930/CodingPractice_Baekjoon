package BOJ.bruteforce.combination.암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;

public class Main {

	static String[] arr;
	static LinkedList<String> res = new LinkedList<>();
	static Set<String> vowels = Set.of("a","e","i","o","u");
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input=br.readLine().split(" ");
		int l = Integer.parseInt(input[0]), c = Integer.parseInt(input[1]);
		
		arr = br.readLine().split(" ");
		
		Arrays.sort(arr,(a,b)->a.compareTo(b));
		dfs(c,l,0,new LinkedList<>());
		res.sort((a,b)->a.compareTo(b));
		for(String str : res)
			System.out.println(str);
		
		br.close();
	}

	public static void dfs(int n,int m,int idx,LinkedList<Integer> list) {
		if(list.size()==m)
		{
			StringBuilder sb = new StringBuilder();
			int v = 0, w = 0;
			for(int i: list) {
				sb.append(arr[i]);
				if(vowels.contains(arr[i]))
					v++;
				else
					w++;
			}
			if(v>=1 && w>=2)
				res.offer(sb.toString());
			return ;
		}
		
		for(int i=idx;i<n;i++) {
			LinkedList<Integer> tmp = new LinkedList<>(list);
			tmp.add(i);
			dfs(n,m,i+1,tmp);
			tmp.poll();
		}
		
	}
}
