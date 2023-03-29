package BOJ.dp.연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer=0;
        
        int[] arr = new int[n], dp = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<n;i++)
        	arr[i]=Integer.parseInt(input[i]);
        dp[0]=arr[0];
        answer = dp[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.println(answer);
        
        br.close();
    }
}
