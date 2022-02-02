package BOJ.bitmasking.중복_제거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> set = new HashSet<>();
		String[] input = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		for(String t : input) {
			int v = Integer.parseInt(t);
			if(!set.contains(v)) {
				sb.append(v+" ");
				set.add(v);
			}
		}
		System.out.println(sb);
		br.close();
	}

}
