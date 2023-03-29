package BOJ.bruteforce.토너먼트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int kim = Integer.parseInt(input[1])-1;
		int lim = Integer.parseInt(input[2])-1;
		if(n%2==1)
			n++;
		int answer=1;
		while(true) {
			if(Math.abs(kim-lim)==1 && (kim/2==lim/2)) {
				break;
			}
				
			n/=2;
			kim/=2;
			lim/=2;
			answer++;
		}
		System.out.println(answer);
		br.close();
	}

}
