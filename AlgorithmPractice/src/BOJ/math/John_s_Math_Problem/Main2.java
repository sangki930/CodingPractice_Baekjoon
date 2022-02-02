package BOJ.math.John_s_Math_Problem;

import java.io.IOException;

// 출처 : 백준
public class Main2 {

	public static void main(String[] args) throws IOException {
		int i = 0;
        long mod = 998244353, p = 1, c;
        long a[] = new long[250250];
        for (;(c = System.in.read() - 48) >= 0;i++){
            a[i] = c * p;
            p = p * 2 % mod;
        }

        for (c = 0,p = 1;--i >= 0;){
            c += p * a[i] % mod;
            p = p * 11 % mod;
        }

        System.out.println(c % mod);

	}

}
