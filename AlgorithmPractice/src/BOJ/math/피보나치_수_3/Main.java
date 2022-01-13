package BOJ.math.피보나치_수_3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        int pisano = 1500000; // 피사노 주기
        long[] arr = new long[pisano];
        arr[0] = 0; arr[1] = 1;
 
        for(int i=2 ; i<Math.min(n+1, pisano) ; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 1000000;  // 피보나치 수를 1,000,000 으로 나눈 나머지 값을 저장 
        }
 
        if(n >=pisano){
            n %= pisano;
        }
 
        System.out.println(arr[(int) n]);
    }
}