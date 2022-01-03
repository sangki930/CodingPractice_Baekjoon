package BOJ.greedy.A_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
		int answer=0;
		while(b>1) {
//			System.out.println(b);
			if(a==b) break;
			if(b%10==1) {
				b/=10;
				answer++;
			}
			else if(b%2==0) {
				b/=2;
				answer++;
			}else {
				System.out.println(-1);
				return;
			}
		}
		if(a==b)
			System.out.println(answer+1);
		else
			System.out.println(-1);
		
		br.close();
	}

}
