package BOJ.binarysearch.놀이공원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		long n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		long time = 0;
		long low = 1, high = 800000000000000L; // 놀이공원 다 타는 데 최소시간
		while(low<=high){
			long mid = (low+high)/2;
			long cnt = 0;
			for(int i=0;i<arr.length;i++){
				cnt+=high/arr[i];
			}
			if(cnt>=n){
				time = cnt;
				high = mid;
			}else{
				low = mid+1;
			}
		}

		System.out.println(time);

		br.close();
	}
}
