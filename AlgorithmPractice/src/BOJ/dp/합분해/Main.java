package BOJ.dp.합분해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		
		int n = Integer.parseInt(tmp[0]), k = Integer.parseInt(tmp[1]);
		
		int[][] dp = new int[k+1][n+1];
		for(int i=0;i<=n;i++) dp[1][i]=1;
		for(int i=1;i<=k;i++)
		    for(int j=0;j<=n;j++)
		        for(int l=0;l<=j;l++) 
		            dp[i][j] = (dp[i][j] + dp[i-1][j-l])%1_000_000_000;

		System.out.println(dp[k][n]);
        br.close();
	}

}