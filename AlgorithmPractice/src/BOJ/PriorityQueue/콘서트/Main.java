package BOJ.PriorityQueue.ÄÜ¼­Æ®;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] ticket = new boolean[1000001];
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(input[i]);
			if(num >= 1000001) continue;	
			ticket[num] = true;
		}
		int res=-1;
		for(int i = 1; i < ticket.length; i++) {
			if(!ticket[i]) {
				res=i;
				break;
			}
		}
		res=res==-1?1000001:res;
		System.out.println(res);
		br.close();
	}

}
