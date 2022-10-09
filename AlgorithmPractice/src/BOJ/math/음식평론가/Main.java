package BOJ.math.음식평론가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
		System.out.println(new BigInteger(b+"").subtract(new BigInteger(b+"").gcd(new BigInteger(a+""))).toString());
		br.close();
	}

}
