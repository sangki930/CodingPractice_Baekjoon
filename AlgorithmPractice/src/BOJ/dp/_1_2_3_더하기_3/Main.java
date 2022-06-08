package BOJ.dp._1_2_3_���ϱ�_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	public static final int mod = (int)Math.pow(10, 9)+9;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4;i<=1000000;i++)
			dp[i] = (dp[i-1]+ dp[i-2]+ dp[i-3]) %mod;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}
}
