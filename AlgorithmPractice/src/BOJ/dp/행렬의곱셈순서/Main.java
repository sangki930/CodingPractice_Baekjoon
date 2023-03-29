package BOJ.dp.행렬의곱셈순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(tmp[0]);
			arr[i][1] = Integer.parseInt(tmp[1]);
		}
		System.out.println(solution(arr));
		br.close();
	}
	
	public static int solution(int[][] matrix_sizes) {
        int a,b;
        int i,j,k;
        int n = matrix_sizes.length;
        int[][] dp = new int[n+1][n+1];
        for(i=0;i<n;i++){
            for(j=0;j<n-i;j++){
                    a = j;
                    b = j+i;
                    if(a == b){
                        dp[a][b] = 0;
                    }
                    else{
                        dp[a][b] = Integer.MAX_VALUE;
                        for(k = a; k < b; k++){
                            dp[a][b] = Math.min(dp[a][b],dp[a][k] + dp[k+1][b] + ( matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1] ));
                        }
                    }
                }
            }
        return dp[0][n-1];
    }

}
