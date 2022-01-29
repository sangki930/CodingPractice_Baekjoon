package BOJ.recursive.신나는_함수_실행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][][] dp=new int[101][101][101];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<101;i++)
			for(int j=0;j<101;j++)
				for(int k=0;k<101;k++)
					dp[i][j][k]=Integer.MIN_VALUE;
		
		while(true) {
			String[] input  = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]), c = Integer.parseInt(input[2]);
			if(a==-1 && b==-1 && c==-1) break;
			sb.append("w(").append(a+", ").append(b+", ").append(c+") ").append("= ").append(w(a,b,c));
			sb.append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}
	
	public static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0)
		    return 1;
		if (dp[a+50][b+50][c+50]!=Integer.MIN_VALUE)
			return dp[a+50][b+50][c+50];
		if (a > 20 || b > 20 || c > 20)
		    return dp[a+50][b+50][c+50]=w(20, 20, 20);
		if (a < b && b < c)
		    return dp[a+50][b+50][c+50]=w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		return dp[a+50][b+50][c+50]=w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}

}
