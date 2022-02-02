package BOJ.dp.Ezreal_여눈부터_가네_ㅈㅈ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
	private final static int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[3][n+2];
        dp[0][2]=1;
        dp[1][2]=1;
        dp[2][2]=0;
        for(int i=3;i<=n;i++) {
        	dp[0][i] = (dp[1][i-1]+dp[2][i-1])%MOD;
        	dp[1][i] = (dp[2][i-1]+dp[0][i-1])%MOD;
        	dp[2][i] = (dp[0][i-1]+dp[1][i-1])%MOD;
        }
        
        System.out.println(dp[0][n]);
        
        br.close();
    }
}
