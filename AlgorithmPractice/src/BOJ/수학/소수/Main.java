package BOJ.수학.소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		long a = Long.parseLong(input[0]);
		long b = Long.parseLong(input[1]);
		long n = Long.parseLong(input[2]);
		
		StringBuilder sb = new StringBuilder("");
		if(a>=b) {
			a=a-(a/b)*b;
		}
		for(int i=0;i<1000000;i++) {
			sb.append((a*10)/b);
			a=(a*10)-((a*10)/b)*b;
		}
		System.out.println(sb.charAt((int)n-1));
		br.close();
	}

}
