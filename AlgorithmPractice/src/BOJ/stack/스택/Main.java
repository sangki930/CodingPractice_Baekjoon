package BOJ.stack.Ω∫≈√;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String[] input = br.readLine().split(" ");
			String res = "";
			switch(input[0]) {
				case "push"->{
					stack.push(input[1]);
					continue;
				}
				case "pop"->{
					res = stack.isEmpty()?"-1":stack.pop();
				}
				case "size"->{
					res = String.valueOf(stack.size());
				}
				case "empty"->{
					res = stack.isEmpty()?"1":"0";
				}
				case "top"->{
					res = stack.isEmpty()?"-1":stack.peek();
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}

}
