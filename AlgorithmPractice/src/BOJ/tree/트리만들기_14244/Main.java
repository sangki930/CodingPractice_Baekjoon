package BOJ.tree.트리만들기_14244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 트리만들기 - 실버
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m-1;i++) {
			sb.append(i).append(" ").append(m-1).append("\n");
		}
		for(int i=m-1;i<n-1;i++) {
			sb.append(i).append(" ").append(i+1).append("\n");
		}
		System.out.println(sb);
		br.close();
	}


}
