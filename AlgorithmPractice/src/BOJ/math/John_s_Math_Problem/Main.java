package BOJ.math.John_s_Math_Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	private final static long MOD = (long) (119*Math.pow(2,23)+1);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = input.length();
        long answer=0;
        for(int i=0;i<input.length();i++) {
        	int v = input.charAt(i)-'0';
        	long bi1 = new BigInteger("2").modPow(new BigInteger(i+""), new BigInteger(MOD+"")).longValueExact();
        	long bi2 = new BigInteger("11").modPow(new BigInteger((n-1-i)+""),new BigInteger(MOD+"")).longValueExact();
        	long bi3 = (bi1*bi2*v)%MOD;
        	answer=(answer+bi3)%MOD;
        }
        System.out.println(answer);
        br.close();
    }
}
