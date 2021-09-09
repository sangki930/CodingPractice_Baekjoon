package BOJ.dp.평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]),k=Integer.parseInt(input[1]);
		int[] w = new int[n + 1]; // 무게
		int[] v = new int[n + 1]; // 가치
		int[][] dp = new int[n + 1][k + 1];
 
		for (int i = 1; i <= n; i++) {
		input = br.readLine().split(" ");
			w[i] = Integer.parseInt(input[0]);
			v[i] = Integer.parseInt(input[1]);
		}
 
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				
				// i번째 무게를 더 담을 수 없는 경우 
				if(w[i] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				// i번째 무게를 더 담을 수 있는 경우 
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
				}
				
			}
		}
		System.out.println(dp[n][k]);
		br.close();
	}

}
