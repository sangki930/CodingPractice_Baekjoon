package BOJ.greedy.과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Data{
	int d,w;

	public Data(int d, int w) {
		this.d = d;
		this.w = w;
	}

	@Override
	public String toString() {
		return "Data [d=" + d + ", w=" + w + "]";
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<Data> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			list.add(new Data(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1])));
		}
		
		list.sort((o1,o2)->{
			if(o1.d==o2.d) return Integer.compare(o2.w,o1.w);
			return Integer.compare(o1.d, o2.d);
		});
		
		PriorityQueue<Data> pq = new PriorityQueue<Data>(
				(o1,o2)->{
					if(o1.w==o2.w) return Integer.compare(o1.d, o2.d);
					return Integer.compare(o1.w, o2.w);
				}
		);
		
		for(int i=0;i<list.size();) { // cnt : ���� ����
			int day = list.get(i).d;
			while(i<list.size() && list.get(i).d==day) {
				if(pq.size()<day) {
					pq.offer(list.get(i));
				}else if(pq.size()==day) {
					Data data = pq.peek();
					if(data.w<list.get(i).w) {
						pq.poll();
						pq.offer(list.get(i));
					}
				}else {
					pq.poll();
				}
				i++;
			}
//			System.out.println(pq);
		}
		
		long answer = 0;
		while(!pq.isEmpty()) answer+=pq.poll().w;
		System.out.println(answer);
		br.close();
	}

}
