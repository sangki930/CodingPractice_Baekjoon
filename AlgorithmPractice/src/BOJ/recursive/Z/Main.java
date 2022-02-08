package BOJ.recursive.Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int cnt=-1,answer=0;
	static int r,c;
	static boolean flag=false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		r = Integer.parseInt(input[1]); c = Integer.parseInt(input[2]);
		func(n,0,0);
		br.close();
	}
	
	public static void func(int n, int row, int col) {
		if(row==r && col==c) {
			System.out.println(answer);
			return;
		}
		
		if(r<row+(int)Math.pow(2,n) && r>=row && c<col+(int)Math.pow(2,n) && c>=col ) {
			func(n-1,row,col);
			func(n-1,row,col+(int)Math.pow(2, n-1));
			func(n-1,row+(int)Math.pow(2, n-1),col);
			func(n-1,row+(int)Math.pow(2, n-1),col+(int)Math.pow(2, n-1));
		}else {
			answer+=Math.pow(2, 2*n);
		}
	}
}
