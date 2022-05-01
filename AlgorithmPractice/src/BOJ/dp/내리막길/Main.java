package BOJ.dp.내리막길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
	static int[][] dp, map;
	static int n,m;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]); m = Integer.parseInt(input[1]);
		map = new int[n][m];
		dp = new int[n][m];
		
		for(int i=0;i<n;i++) {
			input = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(input[j]);
				dp[i][j]= -1;
			}
		}
		System.out.println(dfs(0,0));
		br.close();
	}
	
	static int dfs(int y, int x) {
		if(y==n-1 && x==m-1) {
			return 1;
		}else if(dp[y][x]==-1) {
			dp[y][x] = 0;
			for(int i=0;i<4;i++) {
				int ny = y+dy[i], nx = x + dx[i];
				if(nx>=0 && ny>=0 && nx<m && ny<n && map[y][x]>map[ny][nx]) {
					dp[y][x]+=dfs(ny,nx);
				}
			}
		}
		
		return dp[y][x];
	}
}
