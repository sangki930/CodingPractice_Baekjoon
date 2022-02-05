package BOJ.math.¼Ò¼ö_2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine());
		long sum=0, min = Integer.MAX_VALUE;
		for(int i=a;i<=b;i++) {
			if(isPrimeNum(i)) {
				sum+=i;
				min = Math.min(i, min);
			}
		}
		if(sum==0) {
			System.out.println(-1);
			br.close();
			return;
		}
		System.out.println(sum);
		System.out.println(min);
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
