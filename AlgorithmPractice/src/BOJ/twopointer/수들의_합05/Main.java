package BOJ.twopointer.수들의_합05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.valueOf(br.readLine());
        int answer=1;
        int sum=1,left=1,right=1;
        while(left<=right && right<=(n/2)+1) {
//        	System.out.println(left+"=>"+right+", sum : "+sum);
        	if(sum<n) {
        		sum+=(++right);
        	}else if(sum==n) {
        		answer++;
        		sum-=(left++);
        	}else if(sum>n) {
        		sum-=(left++);
        	}
        }
        bw.write(answer+"");
        bw.close();
        br.close();
    } 
}