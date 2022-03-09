package BOJ.prefixSum.¼ø¼­½ÖÀÇ°öÀÇÇÕ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = new int[n];
		long sum = 0;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(input[i]);
			sum+=arr[i];
		}
		
		long answer=0;
		for(int i=0;i<n;i++) {
			sum-=arr[i];
			answer+=arr[i]*sum;
		}
		System.out.println(answer);
		br.close();
	}

}
