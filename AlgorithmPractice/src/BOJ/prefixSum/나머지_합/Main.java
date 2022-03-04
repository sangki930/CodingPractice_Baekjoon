package BOJ.prefixSum.나머지_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int[] arr = new int[n+1];
		int[] count = new int[m+1];
		for(int i=1;i<=n;i++) {
			arr[i]=arr[i-1]+Integer.parseInt(input[i-1]);
			arr[i]%=m;
			count[arr[i]]++;
		}
		long answer = count[0];
		for(int i=0;i<m;i++) {
			long now = count[i];
			answer+=now*(now-1)/2;
		}
		
		System.out.println(answer);
		br.close();

	}

}
