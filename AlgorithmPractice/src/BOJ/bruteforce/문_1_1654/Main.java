package BOJ.bruteforce.문_1_1654;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str;
		StringBuilder ans = new StringBuilder();
		while((str=br.readLine())!=null) {
			int n = Integer.parseInt(str);
			int num=0;
			for(int i=1;i<=n;i++) {
				num = num*10+1;
				num%=n;
				if(num==0) {
					bw.write(i+"\n");
					break;
				}
			}
		}
		
		bw.close();
		br.close();

	}

}
