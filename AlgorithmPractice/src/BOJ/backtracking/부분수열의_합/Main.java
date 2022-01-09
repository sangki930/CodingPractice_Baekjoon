package BOJ.backtracking.부분수열의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n,s,answer;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]); 
		s = Integer.parseInt(input[1]);
		arr = new int[n];
		input = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(input[i]);
		}
//		System.out.println(Arrays.toString(arr));
		func(0,0);
		System.out.println(s==0?answer-1:answer);
		br.close();
	}
	
	public static void func(int cur, int sum) {
		if (cur == n) { 
			if (sum == s) {
//				System.out.println("결과");
				answer++;
			} 
			return; 
		}
		func(cur + 1, sum);
		func(cur + 1, sum + arr[cur]);
	}

}
