package BOJ.dp.가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String input[]=br.readLine().split(" ");
		int dp[]=new int[n];
		Arrays.fill(dp,1);
		int answer = 0;
		for(int i=1;i<input.length;i++) {
			for(int j=0;j<i;j++) {
				int num1 = Integer.parseInt(input[j]);
				int num2 = Integer.parseInt(input[i]);
				if(num1<num2) {
					dp[i] = Math.max(dp[j]+1,dp[i]);
				}
				
			}
			
		}
		for (int i : dp) {
			answer = Math.max(answer, i);
		}
		System.out.println(answer);
		
		br.close();
	}

}
