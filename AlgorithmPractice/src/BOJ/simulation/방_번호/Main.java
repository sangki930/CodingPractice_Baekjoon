package BOJ.simulation.¹æ_¹øÈ£;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		int[] num = new int[10];
		
		for(int i=0;i<n.length();i++) {
			if(n.charAt(i)=='9' || n.charAt(i)=='6')
				num[6]++;	
			else
				num[n.charAt(i)-'0']++;
		}
		
		num[6]=(int)Math.ceil(num[6]/2.0);
		
		int answer = 0;
		for(int m : num)
			answer = Math.max(answer, m);
		System.out.println(answer);
		br.close();
	}

}
