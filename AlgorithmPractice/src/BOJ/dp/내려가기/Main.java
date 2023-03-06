package BOJ.dp.내려가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		int[][] dp_max = new int[n][3];
		int[][] dp_min = new int[n][3];
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
				dp_max[i][j] = arr[i][j];
				dp_min[i][j] = (int)Math.pow(2, 29);
			}
		}
		dp_min[0][0] = arr[0][0];
		dp_min[0][1] = arr[0][1];
		dp_min[0][2] = arr[0][2];
		for(int i=1;i<n;i++) {
			
			dp_max[i][0] = Math.max(dp_max[i-1][0]+arr[i][0], dp_max[i][0]);
			dp_max[i][1] = Math.max(dp_max[i-1][0]+arr[i][1], dp_max[i][1]);
			
			dp_max[i][0] = Math.max(dp_max[i-1][1]+arr[i][0], dp_max[i][0]);
			dp_max[i][1] = Math.max(dp_max[i-1][1]+arr[i][1], dp_max[i][1]);
			dp_max[i][2] = Math.max(dp_max[i-1][1]+arr[i][2], dp_max[i][2]);
			
			dp_max[i][1] = Math.max(dp_max[i-1][2]+arr[i][1], dp_max[i][1]);
			dp_max[i][2] = Math.max(dp_max[i-1][2]+arr[i][2], dp_max[i][2]);
			
			dp_min[i][0] = Math.min(dp_min[i-1][0]+arr[i][0], dp_min[i][0]);
			dp_min[i][1] = Math.min(dp_min[i-1][0]+arr[i][1], dp_min[i][1]);
			
			dp_min[i][0] = Math.min(dp_min[i-1][1]+arr[i][0], dp_min[i][0]);
			dp_min[i][1] = Math.min(dp_min[i-1][1]+arr[i][1], dp_min[i][1]);
			dp_min[i][2] = Math.min(dp_min[i-1][1]+arr[i][2], dp_min[i][2]);
			
			dp_min[i][1] = Math.min(dp_min[i-1][2]+arr[i][1], dp_min[i][1]);
			dp_min[i][2] = Math.min(dp_min[i-1][2]+arr[i][2], dp_min[i][2]);
			
			
		}
		
		int answer_max = Integer.MIN_VALUE, answer_min = Integer.MAX_VALUE;
		for(int i=n-1;i<n;i++) {
			for(int j=0;j<3;j++) {
				answer_max = Math.max(answer_max, dp_max[i][j]);
				answer_min = Math.min(answer_min, dp_min[i][j]);
			}
		}
		
		System.out.println(answer_max+" "+answer_min);
		
		br.close();
	}

}
