package BOJ.누적합.두_배열의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int na = Integer.parseInt(br.readLine());
		long[] A = new long[na+1];
		String[] input = br.readLine().split(" ");
		for(int i=1;i<=na;i++) {
			A[i] = Long.parseLong(input[i-1]) + A[i-1];
		}
		int nb = Integer.parseInt(br.readLine());
		long[] B = new long[nb+1];
		input = br.readLine().split(" ");
		for(int i=1;i<=nb;i++) {
			B[i] = Long.parseLong(input[i-1]) + B[i-1];
		}
		long answer=0;
		Map<Long,Long> map = new HashMap<>();
	
		for(int i=1;i<na+1;i++) {
			for(int j=i;j<na+1;j++) {
				long key = A[j]-A[i-1];
				map.put(key,map.getOrDefault(key, 0L)+1L);
			}
		}
		
		for(int i=1;i<nb+1;i++) {
			for(int j=i;j<nb+1;j++) {
				long key = B[j]-B[i-1];
				answer+=map.getOrDefault(t-key, 0L);
			}
		}
		System.out.println(answer);
		
		br.close();

	}

}
