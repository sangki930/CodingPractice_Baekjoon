package BOJ.math.ºÐ¼öÇÕ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input[]=br.readLine().split(" ");
		long a1 = Long.parseLong(input[0]), a2 = Long.parseLong(input[1]);
		input=br.readLine().split(" ");
		long b1 = Long.parseLong(input[0]), b2 = Long.parseLong(input[1]);
		
		long res1 = a1*b2+a2*b1;
		long res2 = a2*b2;
		long g = gcd(res1,res2);
		System.out.println((res1/g)+" "+(res2/g));
		
		br.close();
	}
	
	public static long gcd(long a, long b) {
		while(b!=0) {
			long r = a%b;
			a=b;
			b=r;
		}
		return a;
	}

}
