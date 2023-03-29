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
        int[][] map = new int[n+1][m+1];
        long[][] dp = new long[n+1][m+1];
        
        for(int i=1;i<=n;i++) {
        	input = br.readLine().split(" ");
        	for(int j=1;j<=m;j++) {
        		map[i][j] = Integer.parseInt(input[j-1]);
//        		dp[i][j] = Long.MIN_VALUE;
        	}
        }
        for(int i=1;i<=m;i++) dp[1][i] = dp[1][i-1]+map[1][i];
        for(int i=2;i<=n;i++) {
        	long[] tmp1 = new long[m+1], tmp2 = new long[m+1];
        	tmp1[1] = dp[i-1][1] + map[i][1];
        	tmp2[m] = dp[i-1][m] + map[i][m];
        	for(int j=2; j<=m; j++) tmp1[j] = Math.max(dp[i-1][j],tmp1[j-1]) + map[i][j];
            for(int j=m-1;j>=0; j--) tmp2[j] = Math.max(dp[i-1][j], tmp2[j+1]) + map[i][j];
            for(int j=1; j<=m; j++) dp[i][j] = Math.max(tmp1[j], tmp2[j]);
        }
        bw.write(String.valueOf(dp[n][m]));
        br.close();
        bw.close();
    }
}
