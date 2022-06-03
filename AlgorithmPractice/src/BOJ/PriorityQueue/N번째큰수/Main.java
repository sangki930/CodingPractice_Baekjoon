package BOJ.PriorityQueue.N번째큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(a,b));
		
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<tmp.length;j++) {
				pq.offer(Integer.parseInt(tmp[j]));
				if(pq.size()>n) pq.poll();
			}
		}
//		System.out.println(pq);
		System.out.println(pq.poll());
		
		br.close();
	}

}
