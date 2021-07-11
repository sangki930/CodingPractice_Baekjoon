package BOJ.¼öÇÐ.multiply;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	private static final int MAX = 6;
	private static final int PRICE = 5;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input=br.readLine();
		
		input = br.readLine();
		BigInteger n1 = new BigInteger(input);
		input = br.readLine();
		BigInteger n2 = new BigInteger(input);
		
		System.out.println(n1.multiply(n2));
		
		br.close();

	}

}
