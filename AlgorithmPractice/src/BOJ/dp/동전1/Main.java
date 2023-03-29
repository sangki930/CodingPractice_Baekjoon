package BOJ.dp.동전1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
		int[] arr = new int[n+2];
		int[] dp = new int[k+2];
		dp[0]=1;
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for(int j=arr[i];j<=k;j++) {
				dp[j]+=dp[j-arr[i]];
			}
		}
		System.out.println(dp[k]);
		br.close();
	}
 
}