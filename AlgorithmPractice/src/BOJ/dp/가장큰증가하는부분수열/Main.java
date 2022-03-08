package BOJ.dp.가장큰증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다이내믹 프로그래밍
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] arr = new int[n+1];
			int[] dp = arr.clone();
			int max = Integer.MIN_VALUE;
			for(int i=1;i<=n;i++) {
				arr[i]=Integer.parseInt(input[i-1]);
			}
			
			for(int i=1;i<=n;i++) {
				dp[i]=arr[i];
				for(int j=1;j<i;j++)
					if(arr[j]<arr[i] && dp[i]<dp[j]+arr[i])
						dp[i] = dp[j]+arr[i];
				max = Math.max(dp[i], max);
			}
			System.out.println(max);
			
			br.close();
	}

}
