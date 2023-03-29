package BOJ.greedy.수리공_항승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), l=Integer.parseInt(input[1]);
		int[] arr = new int[n];
		input = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);
		int start = arr[0], len = 1;//len : ���� ����
		int answer = 1; // ����
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]-start>=l) {
				answer++;
				start=arr[i];
			}
		}
		System.out.println(answer);
		br.close();
	}

}
