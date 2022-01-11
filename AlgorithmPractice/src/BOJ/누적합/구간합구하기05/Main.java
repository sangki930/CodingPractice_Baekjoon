package BOJ.누적합.구간합구하기05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		int[][] table=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			input = br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				table[i][j]=table[i][j-1]+table[i-1][j]+Integer.parseInt(input[j-1])-table[i-1][j-1];
			}
		}
		
//		for(int i=0;i<n+1;i++)
//			System.out.println(Arrays.toString(table[i]));
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<m;i++) {
			input = br.readLine().split(" ");
			int x1=Integer.parseInt(input[0]), y1 = Integer.parseInt(input[1]);
			int x2=Integer.parseInt(input[2]), y2 = Integer.parseInt(input[3]);
			sb.append(table[x2][y2]-table[x2][y1-1]-table[x1-1][y2]+table[x1-1][y1-1]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();

	}

}
