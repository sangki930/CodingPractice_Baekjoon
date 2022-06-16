package BOJ.greedy.аж╫д;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] arr = new int[n];
			for(int j=0;j<n;j++)
				arr[j] = Integer.parseInt(input[j]);
			
			long answer = 0;
			int high = 0;
			for(int j=n-1;j>=0;j--) {
				if(high>arr[j]) answer+=(high - arr[j]);
				else high = arr[j];
			}
			System.out.println(answer);
		}
		
		br.close();
	}

}
