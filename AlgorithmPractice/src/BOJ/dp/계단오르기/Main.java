package BOJ.dp.계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];
        int a[] = new int[n+1];
        
        for(int i=1; i<=n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
 
        dp[1] = a[1];
        if(n >= 2) dp[2] = dp[1]+a[2];
     
        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-2]+a[i],dp[i-3]+a[i-1]+a[i]); 
        }
         
        System.out.println(dp[n]);
        
        br.close();
    }
}
