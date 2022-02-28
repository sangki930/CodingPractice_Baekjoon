package BOJ.prefixSum.¼ö¿­;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]),answer=Integer.MIN_VALUE;
		int[] arr = new int[n+1];
		input = br.readLine().split(" ");
		for(int i=1;i<=n;i++) {
			arr[i] = arr[i-1]+Integer.parseInt(input[i-1]);
		}
		for(int i=k;i<=n;i++) {
			answer = Math.max(answer, arr[i]-arr[i-k]);
		}
		System.out.println(answer);
		br.close();

	}

}
