package BOJ.greedy.¡÷¿Øº“;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		long total,c_now;
		int n = Integer.parseInt(br.readLine());
		int[] dist = new int[100001], cost = dist.clone();
		
		String[] input = br.readLine().split(" ");
		for(int i=1;i<n;i++)
			dist[i]=Integer.parseInt(input[i-1]);
		input = br.readLine().split(" ");
		for(int i=0;i<n;i++)
			cost[i]=Integer.parseInt(input[i]);
		c_now=cost[0];
		total = c_now*dist[1];
		for(int i=1; i<n; i++){
	        if(c_now < cost[i]){
	            total += c_now * dist[i+1];
	        }
	        else{
	            c_now = cost[i];
	            total += c_now*dist[i+1];
	        }
	    }
		System.out.println(total);
		br.close();
	}

}
