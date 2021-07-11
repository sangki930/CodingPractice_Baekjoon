package BOJ.hash.´ëÄªÂ÷ÁýÇÕ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		
		Map<String,Integer> map = new HashMap<>();
		input = br.readLine().split(" ");
		for(int i=0;i<input.length;i++) {
			String tmp=input[i];
			map.put(tmp, map.getOrDefault(tmp, 0)+1);
		}
		input = br.readLine().split(" ");
		for(int i=0;i<input.length;i++) {
			String tmp=input[i];
			map.put(tmp, map.getOrDefault(tmp, 0)+1);
		}
		int answer = 0;
		for(String s : map.keySet()) {
			if(map.get(s)==1)
				answer++;
		}
		System.out.println(answer);
		
		br.close();

	}

}
