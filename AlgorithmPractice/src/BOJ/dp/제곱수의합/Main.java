package BOJ.dp.Á¦°ö¼öÀÇÇÕ;

import java.util.Scanner;

public class Main{

public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N=sc.nextInt();
    long dp[] = new long[100001];
    
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j*j <= i; j++){
            if (dp[i] > dp[i - j*j] + 1 || dp[i] == 0)
                dp[i] = dp[i - j*j] + 1;
        }
    }
    
    System.out.println(dp[N]);

}

}
