package BOJ.math.SASA_모형을_만들어보자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m=Integer.parseInt(input[1]);
		
		System.out.println(Math.min(n, m)/2);
		
		br.close();
	}

}
