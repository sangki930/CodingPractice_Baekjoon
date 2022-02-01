package BOJ.prefixSum.구간합구하기04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		
		int arr[]=new int[n];
		int nums[]=new int[n];
		nums[0]=arr[0]=Integer.parseInt(input[0]);
		for(int i=1;i<n;i++) {
			nums[i] = Integer.parseInt(input[i]);
			arr[i]=arr[i-1]+Integer.parseInt(input[i]);
		}
		StringBuilder sb = new StringBuilder();
		for(int k=0;k<m;k++) {
			input = br.readLine().split(" ");
			int i = Integer.parseInt(input[0]);
			int j = Integer.parseInt(input[1]);
			sb.append(arr[j-1]-arr[i-1]+nums[i-1]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();

	}

}
