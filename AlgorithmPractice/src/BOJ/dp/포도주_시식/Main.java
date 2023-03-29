package BOJ.dp.포도주_시식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer=0;
        int[] arr = new int[n],dp = new int[n];
        for(int i=0;i<n;i++)
        	arr[i]=Integer.parseInt(br.readLine());
        if(n>=1)dp[0]=arr[0];
        if(n>=2)dp[1]=arr[0]+arr[1];
        if (n >= 3) {
            dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));
        }
        for(int i=3;i<arr.length;i++) {
        	dp[i] = Math.max(dp[i-3] + arr[i] + arr[i-1], dp[i-2] + arr[i]); 
        	dp[i] = Math.max(dp[i-1], dp[i]);
        	//������ 2���������� �ȸ��ô� ��쵵 ����
        }
        System.out.println(dp[n-1]);
        br.close();
    }
}
