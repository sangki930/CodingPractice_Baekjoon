package BOJ.prefixSum.개똥벌레;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), h = Integer.parseInt(input[1]);
		int[] top = new int[h+1], bottom = new int[h+1];
		
		// 높이의 개수를 센다
		for(int i=0;i<n/2;i++) {
			top[Integer.parseInt(br.readLine())]++;
            bottom[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i=h-1;i>0;i--) {
			top[i]+=top[i+1];
			bottom[i]+=bottom[i+1];
		}
		
		int[] stone = new int[h+1];
		int min = Integer.MAX_VALUE;
		
		for(int i=1;i<=h;i++) {
			stone[i] = bottom[i]+top[h-i+1];
			min = Math.min(min, stone[i]);
		}
		
		int cnt=0;
		for(int i=1;i<=h;i++)
			if(stone[i]==min)
				cnt++;
		System.out.println(min + " " + cnt);
		
		br.close();
	}
}
