package BOJ.prefixSum.Maximum_Subarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n+1];
			String[] input = br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				dp[j] = Integer.parseInt(input[j-1])+dp[j-1];
			}
			int answer=Integer.MIN_VALUE;
			for(int j=1;j<=n;j++) {
				for(int k=0;k<j;k++) {
					answer = Math.max(dp[j]-dp[k], answer);
					
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
