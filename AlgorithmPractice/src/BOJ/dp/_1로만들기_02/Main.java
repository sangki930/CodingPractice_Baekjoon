package BOJ.dp._1로만들기_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 1];
        int before[] = new int[n+1];
        before[1]=-1;
        
        for (int i = 2; i <= n; i++) {
    		dp[i] = dp[i - 1] + 1;
    		before[i] = i - 1;

    		if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
    			dp[i] = dp[i / 2] + 1;
    			before[i] = i / 2;
    		}
    		if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
    			dp[i] = dp[i / 3] + 1;
    			before[i] = i / 3;
    		}
    	}
        
        StringBuilder sb = new StringBuilder(dp[n]+"\n");
        while(n!=-1) {
        	sb.append(n).append(" ");
        	n = before[n];
        }
        System.out.println(sb);
        
        br.close();
    }
}