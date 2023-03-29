package BOJ.dp.동전2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
 
public class Main {
 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
		Set<Integer> set = new HashSet<>();
		
		for(int i=0;i<n;i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		int[] coins = new int[set.size()];
		int idx = 0;
		for(int i  :set) {
			coins[idx++] = i;
		}
		int[] dp = new int[k+1];
		Arrays.fill(dp, 100000000);
		dp[0]=0;
		for(int i=0;i<set.size();i++) {
			int coin = coins[i];
			for(int j=coin;j<=k;j+=1) {
				dp[j] = Math.min(dp[j-coin]+1,dp[j]);
			}
		}
		int answer = (dp[k]==100000000)?-1:dp[k];
		System.out.println(answer);
		
		br.close();
	}
 
}