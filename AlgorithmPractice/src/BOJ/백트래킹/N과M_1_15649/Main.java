package BOJ.백트래킹.N과M_1_15649;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

	private static StringBuilder ans = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input[]=br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		dfs(n,m,0,new ArrayList<>());
		bw.write(ans.toString());
		bw.close();
		br.close();
	}
	
	public static void dfs(int n,int m,int idx,ArrayList<Integer> list) {
		
		StringBuilder sb = new StringBuilder("");
		if(list.size()==m)
		{
			for(int i : list) {
//				sb.append((i+1)+" ");
				ans.append(i+1).append(" ");
			}
			ans.append("\n");
			return ;
		}
		
		for(int i=0;i<n;i++) {
			ArrayList<Integer> tmp = new ArrayList<>(list);
			if(tmp.contains(i))
				continue;
			tmp.add(i);
			dfs(n,m,i+1,tmp);
			tmp.remove(new Integer(i));
		}
		
	}

}
