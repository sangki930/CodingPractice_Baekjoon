package BOJ.math.∞ÒµÂπŸ»Â¿«_√ﬂ√¯._6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=-1;
		StringBuilder sb = new StringBuilder();
		while((n=Integer.parseInt(br.readLine()))!=0) {
			int i=3;
			boolean flag=false;
			for(i=3;i<=n/2;i++) {
				if(isPrimeNum(i) && isPrimeNum(n-i)) {
					flag=true;
					break;
				}
			}
			if(flag) {
				sb.append(n+" = "+i+" + "+(n-i));
			}else {
				sb.append("Goldbach's conjecture is wrong.");
			}
			sb.append("\n");
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
