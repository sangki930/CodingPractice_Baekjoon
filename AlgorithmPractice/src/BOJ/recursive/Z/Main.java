package BOJ.recursive.Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int answer=-1;
	static int r,c;
	static boolean flag=false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		r = Integer.parseInt(input[1]); c = Integer.parseInt(input[2]);
		func(n,0,0);
		System.out.println(answer);
		br.close();
	}
	
	public static void func(int n, int row, int col) {
		
		if(n==0)
		{
//			System.out.println(row+" "+col);
			answer++;
			if(row==r && col==c) {
				flag=true; 
			}
			return;
		}
		
		func(n-1,row,col);
		if(flag) return ;
		func(n-1,row,col+(int)Math.pow(2, n-1));
		if(flag) return ;
		func(n-1,row+(int)Math.pow(2, n-1),col);
		if(flag) return ;
		func(n-1,row+(int)Math.pow(2, n-1),col+(int)Math.pow(2, n-1));
	}

}
