package BOJ.greedy.º¸¼®_µµµÏ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Jewel{
	int m,v;
	public Jewel(int m, int v) {
		this.m = m;
		this.v = v;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n =Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
		PriorityQueue<Jewel> pq = new PriorityQueue<>((a,b)->{
			if(a.m==b.m) return Integer.compare(b.v, a.v);
			return Integer.compare(a.m,b.m);
		});
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b)->b-a);
		int arr[]=new int[k];
		long answer=0;
		for(int i=0;i<n;i++) {
			input = br.readLine().split(" ");
			int m = Integer.parseInt(input[0]), v= Integer.parseInt(input[1]);
			pq.offer(new Jewel(m,v));
		}
		for(int i=0;i<k;i++) {
			int c = Integer.parseInt(br.readLine());
			arr[i]=c;
		}
		Arrays.sort(arr);
		
		for(int i=0;i<k;i++) {
			int s=0;
			while(!pq.isEmpty() && pq.peek().m<=arr[i]) {
				pq2.offer(pq.poll().v);
			}
			if(!pq2.isEmpty()) {
				answer+=pq2.poll();
			}
			
		}
		System.out.println(answer);
		br.close();
	}

}