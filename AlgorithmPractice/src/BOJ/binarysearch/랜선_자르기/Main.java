package BOJ.binarysearch.랜선_자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int k = Integer.parseInt(input[0]), n = Integer.parseInt(input[1]);
		int[] arr = new int[k];
		
		long max = 0;
		
		for(int i=0;i<k;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i],max);
		}
		max++;
		long min = 0, mid = 0;
		
		while(min<max) {
			mid = (max+min)/2;
			long cnt=0;
			for(int i=0;i<arr.length;i++) {
				cnt+=(arr[i]/mid);
			}
			
			if(cnt<n) max=mid;
			else min = mid+1;
		}
		System.out.println(min-1);
		br.close();
	}

}
