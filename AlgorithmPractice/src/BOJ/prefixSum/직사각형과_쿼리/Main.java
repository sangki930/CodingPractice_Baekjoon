package BOJ.prefixSum.직사각형과_쿼리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][][] arr = new int[11][n+1][n+1];
		int[][][] dp = new int[11][n+1][n+1];
		String[] input;
		for(int i=1;i<=n;i++) {
			input = br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				int k = Integer.parseInt(input[j-1]);
				dp[k][i][j]++;
				for(int l=1;l<=10;l++)
					dp[l][i][j]+=dp[l][i-1][j]+dp[l][i][j-1]-dp[l][i-1][j-1];
			}
		}
		StringBuilder sb = new StringBuilder();
		int q = Integer.parseInt(br.readLine());
		for(int i=0;i<q;i++) {
			input = br.readLine().split(" ");
			int x1 = Integer.parseInt(input[0]), y1 = Integer.parseInt(input[1]);
			int x2 = Integer.parseInt(input[2]), y2 = Integer.parseInt(input[3]);
			int answer=0;
			for(int k=1;k<=10;k++) {
				int v = dp[k][x2][y2] - dp[k][x2][y1-1] - dp[k][x1-1][y2] + dp[k][x1-1][y1-1];
				answer+=Math.min(v, 1);
			}
			sb.append(answer+"\n");
			
		}
		System.out.println(sb);
		br.close();

	}

}
