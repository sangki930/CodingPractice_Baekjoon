package BOJ.binarysearch.¿¹»ê;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = new int[n];
		int max = 0;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(input[i]);
			max = Math.max(max, arr[i]);
		}
			
		int m = Integer.parseInt(br.readLine());
		long left = 0, right = max, answer=0;
		
		while(left<=right) {
			long sum=0, mid = (left+right)/2;
//			System.out.println("left : "+left+", right : "+right);
			for(int i=0;i<n;i++) {
				sum+=Math.min(arr[i], mid);
			}
			if(sum>m) {
				right = mid-1;
			}else {
				left = mid+1;
				answer = Math.max(answer, mid);
			}
		}
		System.out.println(answer);
		
		br.close();
	}

}
