package BOJ.math.º­¶ôÄ¡±â;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		long answer = -1;
		if(n<=2) {
			answer = n;
		}else if(n<=4) {
			answer = (n-1);
		}else if(n==5 || n==6) {
			answer = 3;
		}else if(n>=7 && n<=10) {
			answer = 4;
		}else if(n>=11 && n<=15) {
			answer = 5;
		}else if(n>=16 && n<=21) {
			answer = 6;
		}else if(n>=22 && n<=28) {
			answer = 7;
		}else {
			long k = (n+21)/7;
			answer = ((n+21)%7==0)?k:k+1L;
		}
		System.out.println(answer);
		br.close();
	}

}
