package BOJ.recursive.Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int cnt=-1,answer=-1;
	static int r,c;
	static boolean flag=false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		r = Integer.parseInt(input[1]); c = Integer.parseInt(input[2]);
		func(n,0,0);
		System.out.println(cnt);
		br.close();
	}
	
	public static void func(int n, int row, int col) {
		System.out.println("n : "+n+", row : "+row+", col : "+col);
		System.out.println(answer);
		if(n==0)
		{
//			System.out.println(row+" "+col);
			answer++;
			if(row==r && col==c) {
				cnt=answer;
			}
			return;
		}
		System.out.println("확인1");
		if(r>=row && r<row+Math.pow(2, n-1) && c>=col && c<col+Math.pow(2, n-1)) {
//			System.out.println("확인");
			func(n-1,row,col);
		}
		else answer+=Math.pow(2, 2*n-2);
		System.out.println("확인2");
		if(r>=row && r<row+Math.pow(2, n-1) && c>=col+(int)Math.pow(2, n-1) && c<Math.pow(2, n))
		func(n-1,row,col+(int)Math.pow(2, n-1));
		else answer+=Math.pow(2, 2*n-2);
		System.out.println("확인3");
		if(r>=row+(int)Math.pow(2, n-1) && r<row+Math.pow(2, n) && c>=col && c<Math.pow(2, n-1))
		func(n-1,row+(int)Math.pow(2, n-1),col);
		else answer+=Math.pow(2, 2*n-2);
		System.out.println("확인4");
		if(r>=row+(int)Math.pow(2, n-1) && r<row+Math.pow(2, n) && c>=col+(int)Math.pow(2, n-1) && c<Math.pow(2, n))
		func(n-1,row+(int)Math.pow(2, n-1),col+(int)Math.pow(2, n-1));
		else answer+=Math.pow(2, 2*n-2);
		cnt=answer;
	}

}
