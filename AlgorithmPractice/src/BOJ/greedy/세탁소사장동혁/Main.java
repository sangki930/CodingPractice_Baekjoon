package BOJ.greedy.ºº≈πº“ªÁ¿Âµø«ı;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int cost = Integer.parseInt(br.readLine());
			int a = (int)cost/25;
            int b = (int)(cost-a*25)/10;
            int c = (int)(cost-a*25-b*10)/5;
            int d = cost-a*25-b*10-c*5;
            sb.append(a+ " "+b+ " "+c+ " "+d+"\n");                                                  
            
		}
		System.out.print(sb);
		
		br.close();
	}
}