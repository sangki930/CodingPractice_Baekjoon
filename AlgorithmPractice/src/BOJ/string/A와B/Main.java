package BOJ.string.A��B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine(); //ó��
		String res = br.readLine(); //��
		int n = res.length(), ret = 0;
		
		StringBuilder sb = new StringBuilder(res);
		while(true) {
			if(sb.length() == first.length()) {
				if(first.contentEquals(sb)) {
					ret = 1;
				}
				break;
			}
			
			char c = sb.charAt(sb.length()-1);
			sb.deleteCharAt(sb.length()-1);
			if(c=='B')
				sb = sb.reverse();
			
		}
		System.out.println(ret);
		br.close();

	}

}
