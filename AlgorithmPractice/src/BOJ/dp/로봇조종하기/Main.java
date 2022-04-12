package BOJ.dp.로봇조종하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
        int[][] map = new int[n][m];
        long[][] dp = new long[n][m];
        
        for(int i=0;i<n;i++) {
        	input = br.readLine().split(" ");
        	for(int j=0;j<m;j++) {
        		map[i][j] = Integer.parseInt(input[j]);
        		dp[i][j] = Long.MIN_VALUE;
        	}
        }
        dp[0][0] = map[0][0];
        for(int i=1;i<m;i++) {
        	dp[0][i] = Math.max(dp[0][i-1]+map[0][i], dp[0][i]);
        }
//      for(int i=0;i<n;i++)
//    	System.out.println(Arrays.toString(dp[i]));
//      System.out.println("====================");
        for(int i=1;i<n;i++) {
        	int[] tmp1 = new int[m], tmp2 = new int[m];
        	
        }
        bw.write(String.valueOf(dp[n-1][m-1]));
        br.close();
        bw.close();
    }
}
