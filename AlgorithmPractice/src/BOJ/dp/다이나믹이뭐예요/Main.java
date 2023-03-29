package BOJ.dp.다이나믹이뭐예요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int n = Integer.parseInt(input[0]),m=Integer.parseInt(input[1]);
		
		long dp[][]=new long[n+1][m+1];
		
		for(int i=1;i<=n;i++)
			dp[i][1]=1;
		for(int i=1;i<=m;i++)
			dp[1][i]=1;
		for(int i=2;i<=n;i++)
			for(int j=2;j<=m;j++)
				dp[i][j]=(dp[i-1][j]+dp[i][j-1]+dp[i-1][j-1])%((int)1e9+7);
//		System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[n][m]);
        br.close();
	}

}
