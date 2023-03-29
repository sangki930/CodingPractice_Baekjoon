package BOJ.dp.이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//11048 �̵��ϱ� - �ǹ�2
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		
		int n = Integer.parseInt(tmp[0]), m = Integer.parseInt(tmp[1]);
		
		int[][] arr = new int[n][m];
		for(int i=0;i<n;i++) {
			tmp = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		int[][] dp = new int[n][m];
		
		dp[0][0] = arr[0][0];
		for(int i=1;i<m;i++)
			dp[0][i] = dp[0][i-1]+arr[0][i];
		for(int i=1;i<n;i++)
			dp[i][0] = dp[i-1][0]+arr[i][0];
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1],dp[i-1][j]))+arr[i][j];
			}
		}
		
		System.out.println(dp[n-1][m-1]);
        br.close();
	}

}