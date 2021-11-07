package BOJ.math.평균은넘겠지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println(Math.round(57143.3333333333333333));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String input[]=br.readLine().split(" ");
			int cnt = Integer.parseInt(input[0]),m=0;
			double sum=0,avg=0;
			for(int j=1;j<input.length;j++) {
				sum+=Double.parseDouble(input[j]);
			}
			avg=sum/cnt;
//			System.out.println(avg);
			for(int j=1;j<input.length;j++) {
				if(Double.parseDouble(input[j])>avg) m++;
			}
//			System.out.println(m/(double)n);
			
			
			sb.append(String.format("%.03f", Math.round(m*100000/(double)cnt)/1000.0)+"%").append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
