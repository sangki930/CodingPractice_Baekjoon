package BOJ.divideAndConquer.투에_모스_문자열;

import java.io.*;

public class Main02 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Long.bitCount(Long.parseLong(br.readLine())-1)%2);
		br.close();
	}

}
