package BOJ.queue.Ä«µå2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<n;i++) {
			queue.offer(i+1);
		}
		for(int i=0;i<Integer.MAX_VALUE;i++) {
			if(queue.size()==1) break;
			if(i%2==0) {
				queue.poll();
			}else
				queue.offer(queue.poll());
			
		}
		System.out.println(queue.peek());
		br.close();
	}

}
