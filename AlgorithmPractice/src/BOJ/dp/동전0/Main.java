package BOJ.dp.µ¿Àü0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
 
	public static int[] arr;
	public static int N;
	public static int count = 0;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int width =3, height = 3;
		int[][] diagonals = {{1,1}};
//		int[][] diagonals = {{1,1},{2,2}};
		int mod = 10_000_019;
		int[][][] dp = new int[2][height+1][width+1];
		
		for(int i=1;i<=height;i++) {
			dp[0][i][0] = 1;
		}
		
		for(int i=1;i<=width;i++) {
			dp[0][0][i] = 1;
		}
		
		boolean[][] v1 = new boolean[height+1][width+1];
		boolean[][] v2 = new boolean[height+1][width+1];
		for(int[] diagonal : diagonals) {
			v1[diagonal[1]][diagonal[0]-1]=true;
			v2[diagonal[1]-1][diagonal[0]]=true;
		}
		
		for(int i=1;i<=height;i++) {
			for(int j=1;j<=width;j++) {
				dp[0][i][j] = (dp[0][i-1][j]+dp[0][i][j-1])%mod;
			}
		}
		
		for(int i=0;i<=height;i++) {
			for(int j=0;j<=width;j++) {
				if(v1[i][j]) {
					dp[1][i][j]+=dp[0][i-1][j+1];
//					System.out.println(dp[1][i][j]);
				}
					
				if(v2[i][j]) {
					dp[1][i][j]+=dp[0][i+1][j-1];
//					System.out.println(dp[1][i][j]);
				}
				if(i>=1 && j>=1) {
					dp[1][i][j] += (dp[1][i-1][j]+dp[1][i][j-1])%mod;
				}else if(i==0 && j>0) {
					dp[1][i][j] += dp[1][i][j-1];
				}else if(i>0 && j==0) {
					dp[1][i][j] += dp[1][i-1][j];
				}
			}
		}
		
		
		for(int i=0;i<=height;i++)
			System.out.println(Arrays.toString(dp[0][i]));
		System.out.println("=================================");
		for(int i=0;i<=height;i++)
			System.out.println(Arrays.toString(dp[1][i]));
		
		System.out.println(dp[1][height][width]);
//		int[] costs = {2, 11, 20, 100, 200, 600};
//		int money = 1999;
//		
//		int[] arr = {1,5,10,50,100,500};
//		int[] dp = new int[money+1];
//		Arrays.fill(dp, Integer.MAX_VALUE);
//		dp[0]=0;
//		for(int i=0;i<6;i++) {
//			int coin = arr[i];
//			int cost = costs[i];
//			for(int j=coin;j<=money;j++) {
//				dp[j] = Math.min(dp[j], dp[j-coin]+cost);
//			}
//		}
//		
//		System.out.println(dp[money]);
		
		br.close();
	}
 
}
