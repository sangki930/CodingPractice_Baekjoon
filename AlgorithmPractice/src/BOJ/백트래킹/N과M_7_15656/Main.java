package BOJ.백트래킹.N과M_7_15656;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

	private static StringBuilder sb = new StringBuilder("");
	private static String[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input[]=br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		arr = br.readLine().split(" ");
		Arrays.sort(arr,(a,b)->Integer.compare(Integer.parseInt(a),Integer.parseInt(b)));
		dfs(n,m,0,new LinkedList<>());
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	public static void dfs(int n,int m,int idx,LinkedList<Integer> list) {
		
		
		if(list.size()==m)
		{
			for(int i: list)
				sb.append(arr[i]).append(" ");
			sb.append("\n");
			return ;
		}
		
		for(int i=0;i<n;i++) {
			LinkedList<Integer> tmp = new LinkedList<>(list);
			tmp.add(i);
			dfs(n,m,i+1,tmp);
			tmp.poll();
		}
		
	}

}
