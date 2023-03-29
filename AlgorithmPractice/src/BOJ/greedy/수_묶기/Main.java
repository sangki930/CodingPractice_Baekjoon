package BOJ.greedy.수_묶기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		PriorityQueue<Integer> plus = new PriorityQueue<>(
				(a,b)->Integer.compare(b, a)
				);
		PriorityQueue<Integer> minus = new PriorityQueue<>(
				(a,b)->Integer.compare(a, b)
				);
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>0)
				plus.offer(arr[i]);
			else
				minus.offer(arr[i]);
				
		}
		long answer = 0;
		while(true) {
			if(plus.size()<=1) {
				break;
			}
			int n1 = plus.poll(), n2 = plus.poll();
			if(n1==1 || n2==1) {
				answer += n1+n2;
			}else
				answer+=n1*n2;
		}
		while(true) {
			if(minus.size()<=1) {
				break;
			}
			answer+=minus.poll()*minus.poll();
		}
		
		answer += (plus.isEmpty()?0:plus.poll()) + (minus.isEmpty()?0:minus.poll());
		System.out.println(answer);
		
		br.close();
	}

}
