package BOJ.math.색칠1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		long w = Long.parseLong(input[0]); // 전체 색종이 가로
		long h = Long.parseLong(input[1]); // 전체 색종이 높이
		long f = Long.parseLong(input[2]); // x축
		long c = Long.parseLong(input[3]); // c번 접기
		
		
		// 범위
		long x1 = Long.parseLong(input[4]);
		long y1 = Long.parseLong(input[5]);
		long x2 = Long.parseLong(input[6]);
		long y2 = Long.parseLong(input[7]);
		
		long area = (x2 - x1) * (y2 - y1) * (c+1);
		long answer = 0;
		if (f <= w / 2) { 
			if (f <= x1) { 
				answer = w*h - area;
			}
			else { 
				answer = w*h - (area + (Math.min(f, x2) - x1) * (y2 - y1) * (c+1));
			}
		} 
		else {
			if (w <= x1 + f) {
				answer = w*h - area;
			}
			else { 
				answer = w*h - (area + (Math.min(w, f + x2) - (f + x1)) * (y2 - y1) * (c+1));
			}
		}
		System.out.println(answer);
		
		br.close();
	}

}
