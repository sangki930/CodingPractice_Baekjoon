package BOJ.implementation.�ֻ���������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		int x = Integer.parseInt(input[2]), y = Integer.parseInt(input[3]);
		int k = Integer.parseInt(input[4]);
		
		// ������ 1, ������ 2, ������ 3, ������ 4
		int[][] map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		
		for(int i=0;i<k;i++) {
			
		}
		
		br.close();
	}

}
