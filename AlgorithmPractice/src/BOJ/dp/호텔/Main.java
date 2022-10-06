package BOJ.dp.хёез;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		
		int c = Integer.parseInt(tmp[0]), n = Integer.parseInt(tmp[1]);
		int[] dp = new int[1101];
		Arrays.fill(dp, (int)Math.pow(2, 25));
		dp[0]=0;
		for(int i=0;i<n;i++) {
			tmp = br.readLine().split(" ");
			int cost = Integer.parseInt(tmp[0]), customer = Integer.parseInt(tmp[1]);
			for(int j=customer;j<=1100;j++) {
				dp[j]=Math.min(dp[j],dp[j-customer]+cost);
			}
		}
		int answer = Integer.MAX_VALUE;
		for(int i=c;i<=1100;i++)
			answer = Math.min(answer, dp[i]);
		
		System.out.println(answer);
		
        br.close();
	}

}