package BOJ.recursive.ÄõµåÆ®¸®;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0;i<n;i++)
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		sb.append(func(0,0,n));
		System.out.println(sb);
		br.close();
	}
	
	public static String func(int r, int c, int num) {
		if(num==1) {
//			System.out.println("r  : "+r+", c  : "+c);
			return map[r][c]+"";
		}
		String r1 = func(r,c,num/2);
		String r2 = func(r,c+(num)/2,num/2);
		String r3 = func(r+(num)/2,c,num/2);
		String r4 = func(r+(num)/2,c+(num)/2,num/2);
		String ret = r1+r2+r3+r4;
		if(ret.equals("1111"))
			return "1";
		else if(ret.equals("0000"))
			return "0";
		return "("+ret+")";
	}
	
}
