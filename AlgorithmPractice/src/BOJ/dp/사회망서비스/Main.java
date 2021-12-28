package BOJ.dp.사회망서비스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String input[]=br.readLine().split(" ");
			int u = Integer.parseInt(input[0]), v = Integer.parseInt(input[1]);
		}
		
		br.close();
	}
	
}
