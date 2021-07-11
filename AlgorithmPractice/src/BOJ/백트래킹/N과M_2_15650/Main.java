package BOJ.백트래킹.N과M_2_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		dfs(n,m,0,new ArrayList<>());
		br.close();
	}
	
	public static void dfs(int n,int m,int idx,ArrayList<Integer> list) {
		
		StringBuilder sb = new StringBuilder("");
		if(list.size()==m)
		{
			for(int i : list) {
				sb.append((i+1)+" ");
			}
			System.out.println(sb.toString().trim());
			return ;
		}
		
		for(int i=idx;i<n;i++) {
			ArrayList<Integer> tmp = new ArrayList<>(list);
			tmp.add(i);
			dfs(n,m,i+1,tmp);
			tmp.remove(new Integer(i));
		}
		
	}

}
