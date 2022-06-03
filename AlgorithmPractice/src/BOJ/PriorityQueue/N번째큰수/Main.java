package BOJ.PriorityQueue.N번째큰수;

import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(a,b));
		
		for(int i=0;i<n;i++) {
//			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				pq.offer(sc.nextInt());
				if(pq.size()>n) pq.poll();
			}
		}
//		System.out.println(pq);
		System.out.println(pq.poll());
		
		sc.close();
	}

}
