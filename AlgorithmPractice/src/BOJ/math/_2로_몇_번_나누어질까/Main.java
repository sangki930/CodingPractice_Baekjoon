package BOJ.math._2로_몇_번_나누어질까;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		long a = Long.parseLong(tmp[0]), b = Long.parseLong(tmp[1]);
		
		System.out.println(func(b)-func(a-1));
		br.close();
	}
	
	public static long func(long num) {
		long ret = 0, tmp = 1;
		while(num!=0) {
			ret+=(long)Math.ceil(num)*tmp;
			num /= 2;
			tmp *= 2;
		}
		return ret;
	}

}
