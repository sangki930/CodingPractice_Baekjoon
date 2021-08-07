package BOJ.math.수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());

	    System.out.println(solve(n));
	}
	static int solve(long n) {
	    long sum = 0;
	    int addNum = 0;
	    while(n >= sum) {
	        sum += (++addNum);
	    }

	    return sum == n ? addNum : addNum - 1;
	}

}
