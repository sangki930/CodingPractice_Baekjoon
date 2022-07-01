package BOJ.hash.학생별통화요금계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Data{
	String name;
	int cnt;
	/**
	 * @param name
	 * @param cnt
	 */
	public Data(String name, int cnt) {
		super();
		this.name = name;
		this.cnt = cnt;
	}
	
}

public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Map<String,Integer> result = new HashMap<>();
		List<Data> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String[] input = br.readLine().split(" ");
			String name = input[1];
			input = input[0].split(":");
			int h = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
			int time = h*60+m;
			result.put(name, result.getOrDefault(name, 0)+time);
		}
		
		result.forEach((k,v)->{
			Data data = new Data(k,v);
			if(v<=100) {
				data.cnt = 10;
			}else {
				data.cnt = 10 + (int)Math.ceil((v-100)/50.0)*3;
			}
			list.add(data);
		});
		
		list.sort((a,b)->{
			if(a.cnt==b.cnt)
				return a.name.compareTo(b.name);
			return Integer.compare(b.cnt, a.cnt);
		});
		
		for(Data data : list) {
			System.out.println(data.name+" "+data.cnt);
		}
		
		br.close();
 
	}
 
}
