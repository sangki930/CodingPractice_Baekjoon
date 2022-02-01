package BOJ.divideAndConquer.투에_모스_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01 {

	static int x;

	static long F(long val) {
		if (val == 0)
			return 0;
		if (val == 1)
			return 1;

		if (val % 2 == 0) {
			return F(val / 2);
		} else {
			return 1 - F(val / 2);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		n--;
		System.out.println(F(n));
	}

}
