package BOJ.prefixSum.합_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		String[] input = br.readLine().split(" ");
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(input[i-1])+arr[i-1];
		}
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++) {
			input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]), e = Integer.parseInt(input[1]);
			sb.append(arr[e]-arr[s-1]).append("\n");
		}
		System.out.println(sb);
		br.close();

	}

}
