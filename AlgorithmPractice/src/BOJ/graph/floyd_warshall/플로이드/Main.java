package BOJ.graph.floyd_warshall.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][n+1];
		final int INF = (int)Math.pow(10,9);
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				if(i!=j)
					arr[i][j]=INF;

		for(int k=0;k<m;k++) {
			String[] tmp = br.readLine().split(" ");
			int i = Integer.parseInt(tmp[0]), j = Integer.parseInt(tmp[1]);
			arr[i][j]=Math.min(Integer.parseInt(tmp[2]),arr[i][j]);
		}

		// 플로이드 와샬 알고리즘
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=n;k++) {
					arr[j][k]=Math.min(arr[j][i]+arr[i][k], arr[j][k]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++)
				if(arr[i][j]>=INF)
					sb.append("0 ");
				else
					sb.append(arr[i][j]+" ");
			sb.append("\n");
		}
			
		System.out.println(sb);
		br.close();
	}

}
