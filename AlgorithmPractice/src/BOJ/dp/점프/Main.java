package BOJ.dp.점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		long[][] cnts = new long[n][n];
		for(int i=0;i<n;i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		cnts[0][0]=1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(cnts[i][j]==0 || (i==n-1 && j==n-1) ) continue;
				int v = board[i][j];
				int d = i+v, r = j+v;
				if(0<=r && r<n) cnts[i][r] += cnts[i][j];
				if(0<=d && d<n) cnts[d][j] += cnts[i][j];
			}
		}
		System.out.println(cnts[n-1][n-1]);
		br.close();
	}

}
