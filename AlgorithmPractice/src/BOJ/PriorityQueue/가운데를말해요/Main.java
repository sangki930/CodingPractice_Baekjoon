package BOJ.PriorityQueue.가운데를말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;



public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b);
		
		for(int i=0;i<n;i++) {
			int res=-11111;
			int val = Integer.parseInt(br.readLine());
			if(i%2==0) {
				
				if(maxHeap.isEmpty() && minHeap.isEmpty()) {
					res=val;
					maxHeap.offer(res);
				}else {
					
					if(minHeap.peek()>=val) maxHeap.offer(val);
					else maxHeap.offer(val);
					res = Math.min(minHeap.peek()!=null?minHeap.peek():11111, maxHeap.peek()!=null?maxHeap.peek():11111);
				}
//				System.out.println(maxHeap);
//				System.out.println(minHeap);
			}else {
				if(minHeap.isEmpty()) {
					res = Math.min(val, maxHeap.peek());
					if(maxHeap.peek()>val) minHeap.offer(minHeap.poll());
					else minHeap.offer(val);
				}else {
					if(minHeap.peek()<=val) {
						minHeap.offer(val);
					}else{
						maxHeap.offer(val);
					}
					
					res = Math.min(minHeap.peek()!=null?minHeap.peek():11111, maxHeap.peek()!=null?maxHeap.peek():11111);
				}
//				System.out.println(maxHeap);
//				System.out.println(minHeap);
			}
			System.out.println(res);
		}
		
		br.close();
	}

}
