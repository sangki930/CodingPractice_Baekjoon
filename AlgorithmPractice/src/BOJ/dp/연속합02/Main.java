package BOJ.dp.연속합02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        
        long[][] dp = new long[n+1][2];
        for(int i=0;i<n;i++) {
        	arr[i]=Integer.parseInt(input[i]);
        }
        long answer=arr[0];
        for(int i=0;i<n;i++) {
        	dp[i][0] = dp[i][1] = arr[i];
        	if(i==0) continue;
        	dp[i][0] = Math.max(dp[i-1][0]+arr[i],arr[i]);
        	dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]+arr[i]);
        	answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(answer);
        br.close();
    }
}