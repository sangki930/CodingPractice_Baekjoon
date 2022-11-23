package BOJ.greedy.¼¾¼­;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] input = br.readLine().split(" ");
		for(int i=0;i<input.length;i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		br.close();
	}
}
