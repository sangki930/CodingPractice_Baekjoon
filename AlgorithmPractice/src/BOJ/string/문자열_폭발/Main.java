package BOJ.string.¹®ÀÚ¿­_Æø¹ß;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String del = br.readLine();
		char[] tmp = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		int n = str.length();
		
		for(char ch : tmp) {
			sb.append(ch);
			if(sb.length()<del.length()) continue;
			int len = sb.length();
			while(sb.substring(len-del.length(), len).equals(del)) {
				sb.delete(len-del.length(), len);
				len = sb.length();
				if(len<del.length()) break;
			}
			
		}
		if(sb.isEmpty())
			System.out.println("FRULA");
		else
			System.out.println(sb);
		
		br.close();
	}

}
