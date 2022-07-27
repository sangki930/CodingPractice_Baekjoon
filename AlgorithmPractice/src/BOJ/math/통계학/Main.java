package BOJ.math.통계학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2108 - 실버 3
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			int value = Integer.parseInt(br.readLine());
			arr[i] = value;
			sum += value;
		}
		
		Arrays.sort(arr);
		
		boolean flag = false;
		int mode_max = 0;
		int mode = 10000;
		
		for(int i = 0; i < n; i++) {
			int jump = 0;
			int cnt = 1;
			int i_value = arr[i];
			
			for(int j = i + 1; j < n; j++){
				if(i_value != arr[j]) {
					break;
				}
				cnt++;
				jump++;
			}
			
			if(cnt > mode_max) {
				mode_max = cnt;
				mode = i_value;
				flag = true;
			}
			else if(cnt == mode_max && flag) {
				mode = i_value;
				flag = false;
			}
			
			i += jump;
		}
		
		System.out.println((int)Math.round((double)sum / n)); // 평균
		System.out.println(arr[n / 2]); // 중앙값
		System.out.println(mode); // 최빈값
		System.out.println(arr[n - 1] - arr[0]); // 범위
		
		br.close();
	}
	
}
