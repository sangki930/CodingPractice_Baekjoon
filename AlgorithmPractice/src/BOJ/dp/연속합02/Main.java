package BOJ.dp.¿¬¼ÓÇÕ02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        long result=0L;
        long[][] dp = new long[2][n];
        for(int i=0;i<n;i++) {
        	arr[i]=Integer.parseInt(input[i]);
        }
        
        dp[0][0] = dp[1][0] = arr[0];
        
        for(int i=1;i<n;i++) {
        	
        }
        
        br.close();
    }
}