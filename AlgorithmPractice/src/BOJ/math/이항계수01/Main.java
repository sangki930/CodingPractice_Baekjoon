package BOJ.math.이항계수01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
	static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp = br.readLine().split(" ");
        
        int n = Integer.parseInt(tmp[0]), k = Integer.parseInt(tmp[1]);
        
        dp = new int[n+1][k+1];
        
        System.out.println(func(n,k));
        
        br.close();
    }
    
    public static int func(int n, int k) {
    	if(dp[n][k]>0) return dp[n][k];
    	
    	if(n==k || k==0) return dp[n][k]=1;
    	
    	return dp[n][k] = (func(n-1,k-1)+func(n-1,k))%10007;
    }
}
