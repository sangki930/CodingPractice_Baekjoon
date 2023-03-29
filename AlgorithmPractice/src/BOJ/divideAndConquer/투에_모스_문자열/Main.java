package BOJ.divideAndConquer.투에_모스_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long k = Long.parseLong(br.readLine());
		
		System.out.println(solution(k));
		
		br.close();
	}
	
	public static int solution(long k) {
		if(k<=8) {
			return "01101001".charAt((int)k-1)-'0';
		}
		int cnt=0; //�ɰ�Ƚ��
		long v=k;
		int ret=-1;
		while(true) {
			int a = (int)(Math.log(v-1)/Math.log(2));
			if(v<=8) {
				ret = "01101001".charAt((int)v-1)-'0';
				if(cnt%2==1) ret=ret==0?1:0;
				break;
			}
			v-=(long)Math.pow(2, a);
			cnt++;
		}
		return ret;
	}

}
