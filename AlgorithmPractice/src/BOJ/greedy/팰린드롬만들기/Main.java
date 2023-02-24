package BOJ.greedy.팰린드롬만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int[] cnt = new int[26];
		String a = "";
		for(int i=0;i<s.length();i++) {
			cnt[s.charAt(i)-'A']++;
		}
		String before = "", after = "";
		String middle="";
		int oddNum = 0; // 홀수 개의 개수
		for(int i=0;i<cnt.length;i++) {
			if(cnt[i]>0) {
				if(cnt[i]%2==1) {
					oddNum++;
					middle = (char)(i+'A')+"";
				}
				if(oddNum>=2) {
					System.out.println("I'm Sorry Hansoo");
					br.close();
					return ;
				}
				for(int j=0;j<cnt[i]/2;j++) {
					before+=(char)(i+'A');
					after=(char)(i+'A')+after;
				}
			}
		}
		
		System.out.println(before+middle+after);

		br.close();
	}

}
