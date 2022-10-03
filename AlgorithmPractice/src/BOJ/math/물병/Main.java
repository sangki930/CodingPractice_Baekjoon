package BOJ.math.¹°º´;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        if(n<=k) {
        	answer = 0;
        }else {
        	while(true) {
        		int cnt = 0;
        		int num = n;
        		while(num>0) {
        			if(num%2==1) cnt++;
        			num/=2;
        		}
        		if(cnt<=k) break;
        		
        		n++;
        		answer++;
        	}
        }
		
        System.out.println(answer);
        
		br.close();

	}

}
