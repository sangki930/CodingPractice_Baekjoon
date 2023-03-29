package BOJ.greedy.문서_검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer=0,idx=0;
		String sentence = br.readLine();
		String keyword = br.readLine();
		while(true) {
			idx = sentence.indexOf(keyword, idx);
			if(idx==-1) break;
			idx+=keyword.length();
			answer++;
		}
		System.out.println(answer);
		br.close();
	}

}
