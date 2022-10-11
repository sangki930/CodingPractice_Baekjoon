package BOJ.math.��ĥ1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		long w = Long.parseLong(input[0]); // ��ü ������ ����
		long h = Long.parseLong(input[1]); // ��ü ������ ����
		long f = Long.parseLong(input[2]); // x��
		long c = Long.parseLong(input[3]); // c�� ����
		
		
		// ����
		long x1 = Long.parseLong(input[4]);
		long y1 = Long.parseLong(input[5]);
		long x2 = Long.parseLong(input[6]);
		long y2 = Long.parseLong(input[7]);
		
		long len = Math.min(Math.abs(0-f), Math.abs(f-w));
		long new_f = len;
		
		long answer = (y2-y1)*(Math.min(x2, new_f)-x1)*(c+1)*2+Math.max((x2-new_f)*(y2-y1), 0)*(c+1);
		System.out.println(w*h-answer);
		
		br.close();
	}

}
