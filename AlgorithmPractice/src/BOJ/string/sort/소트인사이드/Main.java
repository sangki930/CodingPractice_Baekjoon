package BOJ.string.sort.소트인사이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input=br.readLine();
		char[] ch = input.toCharArray();
		Arrays.sort(ch);
		StringBuilder sb = new StringBuilder();
		for(int i=ch.length-1;i>=0;i--) {
			sb.append(ch[i]);
		}
		System.out.println(sb);
		br.close();

	}

}
