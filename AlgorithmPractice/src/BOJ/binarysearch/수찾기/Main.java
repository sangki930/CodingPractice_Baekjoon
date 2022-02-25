package BOJ.binarysearch.¼öÃ£±â;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		long m = Long.parseLong(input[1]);
		int[] times = new int[n];
		
		for(int i=0;i<n;i++) {
			times[i] = Integer.parseInt(br.readLine());
		}
		long answer = 0,work=0,left=0,right=0,mid=0;
        Arrays.sort(times);
        
        right = (long)times[times.length-1]*m;
        answer=right;
        
        while(left<=right){
            work=0;
            mid = (left+right)/2;
            for(int time : times)
                work+=(mid/time);
            if(work<m)
                left=mid+1;
            else{
                answer=Math.min(answer,mid);
                right=mid-1;
            }
        }
		
		System.out.println(answer);
		
		br.close();
	}

}
