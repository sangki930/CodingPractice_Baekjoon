package BOJ.hash.µË∫∏¿‚;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		
		Set<String> map = new HashSet<>();
		Set<String> set = new TreeSet<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			map.add(br.readLine());
		}
		for(int i=0;i<m;i++) {
			String key = br.readLine();
			if(map.contains(key))
				set.add(key);
		}
		sb.append(set.size()).append("\n");
		for(String key : set) {
			sb.append(key).append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}

}
