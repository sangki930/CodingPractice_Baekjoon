package BOJ.greedy.폴리오미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine()+";";
		int cnt = 0;
		for(int i=0;i<input.length();i++) {
			char v = input.charAt(i);
			if(v=='X') {
				cnt++;
			}else if(v=='.' || v==';') {
				if(cnt%4==0) {
					for(int j=0;j<cnt/4;j++) {
						sb.append("AAAA");
					}
				}else if(cnt%2==0) {
					for(int j=0;j<cnt/4;j++) {
						sb.append("AAAA");
					}
					sb.append("BB");
				}else {
					System.out.println(-1);
					return ;
				}
				if(v==';') break;
				sb.append('.');
				cnt = 0;
			}
		}
		System.out.println(sb);
		br.close();
	}

}
