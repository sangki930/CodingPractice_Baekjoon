package BOJ.binarysearch.나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		input=br.readLine().split(" ");
		int left=0,right=0;
		int arr[]=new int[n];
		for(int i=0;i<input.length;i++) {
			arr[i] = Integer.parseInt(input[i]);
			right = Math.max(arr[i], right);
		}
		int answer=0;
		while(left<=right) {
			int mid = (left+right)/2;
			long sum=0;
			for(int i=0;i<arr.length;i++)
				sum+=Math.max(arr[i]-mid, 0);
			if(sum>=m) {
				answer = mid;
				left = mid+1;
			}else {
				right = mid-1;
			}
			
		}
		System.out.println(answer);
		br.close();
	}

}
