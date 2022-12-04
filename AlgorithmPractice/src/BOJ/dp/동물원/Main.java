package BOJ.dp.µ¿¹°¿ø;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[3][n+1];
		
		dp[0][1]=1;
		dp[1][1]=1;
		dp[2][1]=1;
		
		for(int i=2;i<=n;i++) {
			dp[1][i] = (dp[2][i-1]%9901+dp[0][i-1]%9901)%9901;
			dp[2][i] = (dp[1][i-1]%9901+dp[0][i-1]%9901)%9901;
			dp[0][i] = (dp[1][i-1]%9901+dp[2][i-1]%9901+dp[0][i-1]%9901)%9901;
		}
		System.out.println((dp[0][n]%9901+dp[1][n]%9901+dp[2][n]%9901)%9901);
		
		
		br.close();
	}
 
}
