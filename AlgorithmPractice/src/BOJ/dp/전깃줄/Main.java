package BOJ.dp.전깃줄;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 출처 : https://st-lab.tistory.com/138
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		
		int[][] wire = new int[n][2];
		
		for(int i=0;i<n;i++) {
			String[] input = br.readLine().split(" ");
			wire[i][0] = Integer.parseInt(input[0]);
			wire[i][1] = Integer.parseInt(input[1]);
		}
		
		// A전봇대를 기준으로 정렬
		Arrays.sort(wire,(a,b)->a[0]-b[0]);
		
		for(int i=0;i<dp.length;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(wire[i][1]>wire[j][1])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		// 전체 개수 - 설치 가능한 전깃줄 = 최소 철거 개수 
		System.out.println(n - max);
		
        br.close();
	}

}