package BOJ.dp.조건에맞는정수의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
// 조건에 맞는 정수의 개수 - 실버1
public class Main {
 
	static int[] arr = {-2,-1,0,1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[9][n];
        
        for(int i=0;i<9;i++) {
        	dp[i][0] = 1;
        }
        
        for(int i=0;i<n-1;i++) {
        	for(int j=1;j<=9;j++) {
        		for(int k=0;k<5;k++) {
        			int nx = arr[k]+j;
        			if(nx>=1 && nx<=9) {
        				dp[j-1][i+1] =(dp[j-1][i+1] + dp[nx-1][i])%987654321L;
        			}
        		}
        	}
        }
        
        long answer = 0;
        for(int i=0;i<9;i++) {
        	answer=(answer+dp[i][n-1])%987654321L;
        }
        
        System.out.println(answer);
        br.close();
    }
}	
