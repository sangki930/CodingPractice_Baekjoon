package BOJ.dp.돌게임2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String answer = "";
		if(n%2==0)
			answer = "SK";
		else
			answer = "CY";
		
		System.out.println(answer);
		br.close();
	}

}
