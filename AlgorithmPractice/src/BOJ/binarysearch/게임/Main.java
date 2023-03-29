package BOJ.binarysearch.게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		
		long x = Long.parseLong(input[0]);
		long y = Long.parseLong(input[1]);
		int z = getPercent(x,y);
		long ans=-1;
		long left=0;
		long right = (long)1e9;
		
		while(left<=right) {
			long mid = (left+right)/2;
			if(getPercent(x+mid,y+mid)!=z) {
				ans=mid;
				right=mid-1;
			}else
				left = mid+1;
		}
		System.out.println(ans);
		
		br.close();
	}
	
	static int getPercent(long x, long y) {
        return (int) (y * 100 / x);
    }

}
