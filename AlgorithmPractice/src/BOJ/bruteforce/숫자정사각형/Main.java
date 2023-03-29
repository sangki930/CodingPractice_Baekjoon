package BOJ.bruteforce.숫자정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int map[][]=new int[n][m];
		
		for(int i=0;i<n;i++) {
			input = br.readLine().split("");
			for(int j=0;j<m;j++)
				map[i][j] = Integer.parseInt(input[j]);
		}
		
		int sq = Math.min(n, m);
		int answer = 1;
		for(int i=2;i<=sq;i++) {
			
			for(int j=0;j<=n-i;j++) {
				for(int k=0;k<=m-i;k++) {
					
					int a = map[j][k];
					int b = map[j+i-1][k+i-1];
					int c = map[j+i-1][k];
					int d = map[j][k+i-1];
					
					Set<Integer> set = new HashSet<>();
					set.addAll(List.of(a,b,c,d));
					
					if(set.size()==1) {
						answer=Math.max(answer, i*i);
					}
					
				}
			}
			
		}
		System.out.println(answer);
		br.close();
	}

}
