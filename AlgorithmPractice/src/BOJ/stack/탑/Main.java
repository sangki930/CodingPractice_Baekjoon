package BOJ.stack.탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Pair{
	int v,idx;
	public Pair(int v, int idx) {
		this.v=v; // 탑의 높이
		this.idx=idx; // 탑의 인덱스
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Pair> stack = new Stack<>();
		String[] input = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int v=Integer.parseInt(input[i]);
			
			while(!stack.isEmpty()) {
				if(stack.peek().v<v) {
					stack.pop();
				}else {
					sb.append(stack.peek().idx).append(" ");
					break;
				}
			}
			
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
				
			stack.push(new Pair(v,i+1));
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
