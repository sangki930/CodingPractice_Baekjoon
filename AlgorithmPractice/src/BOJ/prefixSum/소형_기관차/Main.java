package BOJ.prefixSum.소형_기관차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1], sum = new int[n+1];
		String[] input = br.readLine().split(" ");
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(input[i-1]);
			sum[i]=sum[i-1]+arr[i]; // 누적 합
		}
		
		int max = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[4][n+1];
        for (int i=1; i<=3; i++) {
            for (int j=i*max; j<=n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-max]+sum[j]-sum[j-max]);
            }
        }

        System.out.println(dp[3][n]);

		br.close();
	}

}
