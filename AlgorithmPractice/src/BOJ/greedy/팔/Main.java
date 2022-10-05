package BOJ.greedy.ÆÈ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		long l = Long.parseLong(input[0]), r = Long.parseLong(input[1]);
		
		long l_cnt = Arrays.stream(input[0].split("")).filter(i->i.equals("8")).count();
		long r_cnt = Arrays.stream(input[1].split("")).filter(i->i.equals("8")).count();
		
		char[] l_ch = input[0].toCharArray();
		char[] r_ch = input[1].toCharArray();
		int answer = 0;
		if(input[0].length()==input[1].length()) {
			for(int i=0;i<input[0].length();i++) {
				if(l_ch[i]==r_ch[i] && l_ch[i]=='8') {
					answer++;
				}else if(l_ch[i]!=r_ch[i]) break;
			}
		}
		System.out.println(answer);
		
		br.close();
	}

}
