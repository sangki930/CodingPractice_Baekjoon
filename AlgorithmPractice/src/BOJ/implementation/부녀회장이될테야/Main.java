package BOJ.implementation.부녀회장이될테야;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		int[][] apart = new int[15][15];
		
		for(int i=1;i<=14;i++)
			apart[0][i] = i;
		
		for(int i=1;i<=14;i++) {
			apart[i][1] = 1;
			for(int j=2;j<=14;j++) {
				apart[i][j] = apart[i][j-1] + apart[i-1][j];
			}
		}
		
		for(int i=0;i<t;i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(apart[k][n]);
		}
		
		br.close();

	}

}
