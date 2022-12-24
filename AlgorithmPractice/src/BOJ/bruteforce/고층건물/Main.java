package BOJ.bruteforce.고층건물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] buildings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int answer = 0;
		for(int i=0;i<n;i++) {
			int total = 0;
			int cnt = 0;
			double prev = 0;
			// 기준점의 왼쪽
			for(int j=i-1;j>=0;j--) {
				double slope = (buildings[i]-buildings[j])/(double)(i-j);
				if(j==i-1 || prev > slope) {
					cnt++;
					prev=slope;
				}
			}
			total+=cnt;
			cnt = 0;
			prev = 0;
			// 기준점의 오른쪽
			for(int j=i+1;j<n;j++) {
				double slope = (buildings[i]-buildings[j])/(double)(i-j);
				if(j==i+1 || prev < slope) {
					cnt++;
					prev=slope;
				}
			}
			total+=cnt;
			answer = Math.max(answer, total);
		}
		System.out.println(answer);
		
		br.close();
	}

}
