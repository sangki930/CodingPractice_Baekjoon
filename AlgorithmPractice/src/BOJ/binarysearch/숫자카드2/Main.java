package BOJ.binarysearch.숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), c = Integer.parseInt(input[1]);
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
			
		Arrays.sort(arr);
		
		long answer = 0;
        long left=1,right=arr[n-1]-arr[0]+1,mid=0;
        
        while(left<=right){
            int cnt=0;
            int prev=arr[0];
            mid=(left+right)/2;
            for(int i=1;i<n;i++){
                if(arr[i]-prev>=mid) {
                	cnt++;
                	prev = arr[i];
                }
            }
            if(arr[n-1]-prev<mid)
                cnt++;
            if(cnt>=c){
                answer=Math.max(mid,answer);
                left=mid+1;
            }else
                right=mid-1;
        }
		System.out.println(answer);
		br.close();
	}

}


