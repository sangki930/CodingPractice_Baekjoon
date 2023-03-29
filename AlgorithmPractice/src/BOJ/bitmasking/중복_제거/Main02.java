package BOJ.bitmasking.중복_제거;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ��Ʈ ����ŷ
// ��ó : ����
public class Main02 {
	static final int MAX = 33554432;
	static byte[] arr = new byte[MAX/8+1];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int a = 0;
		while(st.hasMoreTokens()) {
			a = Integer.parseInt(st.nextToken());
			if((arr[a/8]& 1<<(a%8))>=1) {
				continue;
			}else {
				arr[a/8] |= 1<<(a%8);
				sb.append(a).append(" ");
			}
		}
		System.out.println(sb);
	}

}
