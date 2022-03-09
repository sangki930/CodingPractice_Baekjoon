package BOJ.binarysearch.숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		Map<Integer,Integer> map = new HashMap<>();
		input = br.readLine().split(" ");
		for(String in : input)
			map.put(Integer.parseInt(in), map.getOrDefault(Integer.parseInt(in), 0)+1);
		int m = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		for(String in : input) {
			int t = Integer.parseInt(in);
			sb.append(map.getOrDefault(t,0)).append(" ");
		}
		System.out.println(sb);
		br.close();
	}

}
