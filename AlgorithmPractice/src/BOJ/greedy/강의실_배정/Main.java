package BOJ.greedy.강의실_배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Data{
	int start;
	int end;

	public Data(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Data [start=" + start + ", end=" + end + "]";
	}
	
	
}

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Data> pq1 = new PriorityQueue<>((a,b)->{
			if(a.start==b.start)
				return Integer.compare(a.end, b.end);
			return Integer.compare(a.start, b.start);
		});
		PriorityQueue<Data> pq2 = new PriorityQueue<>((a,b)->{
			if(a.end==b.end)
				return Integer.compare(a.start, b.start);
			return Integer.compare(a.end, b.end);
		});
		
		for(int i=0;i<n;i++) {
			String[] input = br.readLine().split(" ");
			pq1.offer(new Data(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
		}
		
		while(!pq1.isEmpty()) {
			Data data = pq1.poll();
			Data data2 = pq2.peek();
			if(data2!=null && data2.end<=data.start) {
				pq2.poll();
			}
			pq2.offer(data);
//			System.out.println(pq2);
		}
		
		System.out.println(pq2.size());
		
		br.close();
	}

}
