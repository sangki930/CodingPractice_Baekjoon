package BOJ.문자열.가장긴문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int left=0,right=2;
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		HashMap<String,Integer> map = new HashMap<>();
		
		while(right<n) {
			
			int idx=-1;
			
			idx = str.indexOf(str.substring(n), n);
			
		}
		
		br.close();
	}

}
