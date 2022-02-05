package BOJ.math.∞ÒµÂπŸ»Â¿«_√ﬂ√¯._9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int j=0;j<t;j++) {
			int n = Integer.parseInt(br.readLine());
			int i = n/2;
			for(i=n/2;i>=2;i--) {
				if(isPrimeNum(i) && isPrimeNum(n-i)) {
					break;
				}
			}
			sb.append(i+" "+(n-i)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	public static boolean isPrimeNum(int num) {
		if(num==1) return false;
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) return false;
		}
		return true;
	}

}
