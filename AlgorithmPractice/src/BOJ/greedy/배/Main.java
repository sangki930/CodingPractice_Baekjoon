package BOJ.greedy.น่;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] crane = new int[n];
		String[] input = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			crane[i] = Integer.parseInt(input[i]);
		}
		int m = Integer.parseInt(br.readLine());
		int[] boxes = new int[n];
		input = br.readLine().split(" ");
		for(int i=0;i<m;i++) {
			boxes[i] = Integer.parseInt(input[i]);
		}
		int left = 0, right= n-1;
		Arrays.sort(boxes);
		Arrays.sort(crane);
		while(left<=right) {
			for(int i=n-1;i>=0;i--) {
//				while()
			}
			left++;
			right--;
		}
		
		br.close();
	}

}
