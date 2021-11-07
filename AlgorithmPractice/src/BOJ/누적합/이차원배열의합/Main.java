package BOJ.누적합.이차원배열의합;

import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]),m=Integer.parseInt(input[1]);
		
		int arr[][]=new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			input = br.readLine().split(" ");
			for(int j=1;j<=m;j++) {
				arr[i][j]=arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1]+Integer.parseInt(input[j-1]);
			}
		}
		
//		for(int i=0;i<=n;i++)
//			System.out.println(Arrays.toString(arr[i]));
		
		int c = Integer.parseInt(br.readLine());
		for(int i=0;i<c;i++) {
			input = br.readLine().split(" ");
			int y1=Integer.parseInt(input[0]);
			int x1=Integer.parseInt(input[1]);
			int y2=Integer.parseInt(input[2]);
			int x2=Integer.parseInt(input[3]);
			System.out.println(arr[y2][x2]-arr[y2][x1-1]-arr[y1-1][x2]+arr[y1-1][x1-1]);
		}
		
		br.close();

	}

}
