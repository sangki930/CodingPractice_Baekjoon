package BOJ.정렬.등수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Record{
	
	int i;
	int score;
	boolean flag;
	public Record(int i, int score, boolean flag) {
		this.i=i;
		this.score=score;
		this.flag=flag;
	}
	
}

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
			
			String input[]=br.readLine().split(" ");
			
			int n = Integer.parseInt(input[0]);
			int new_score = Integer.parseInt(input[1]);
			int p = Integer.parseInt(input[2]);
			
			
			List<Record> list = new ArrayList<>();
			
			if(n==0) {
				System.out.println(1);
				return ;
			}
			
			input = br.readLine().split(" ");
			
			list.add(new Record(-1,new_score,true));
			
			for(int i=0;i<input.length;i++) {
				list.add(new Record(i,Integer.parseInt(input[i]),false));
			}
			
			list.sort((a,b)->{
				if(a.score==b.score)
					return Integer.compare(b.i, a.i);
				return Integer.compare(b.score, a.score);
			});
			Map<Integer,Integer> counter = new HashMap<>();
			for(int i=0;i<p;i++) {
				Record r = list.get(i);
				counter.put(r.score, counter.getOrDefault(r.score, 0)+1);
				if(r.flag) {
					System.out.println(i-counter.get(r.score)+2);
					br.close();
					return ;
				}
			}
			System.out.println(-1);
			br.close();
	}

}