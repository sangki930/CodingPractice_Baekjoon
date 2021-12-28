package BOJ.stack.¸·´ë±â;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int max=-1,answer=1;
		stack.push(Integer.parseInt(br.readLine()));
		max=stack.peek();
		for(int i=1;i<n;i++) {
			int num=Integer.parseInt(br.readLine());
			if(stack.peek()<num) {
				if(max<num) {
					stack.clear();
					stack.push(num);
				}else if(max>=num) {
					while(stack.peek()<=num) {
						stack.pop();
						if(stack.isEmpty()) break;
					}
					
					stack.push(num);
				}
			}else if(stack.peek()==num) continue;
			else stack.push(num);
//			System.out.println(stack);
			max=Math.max(max, num);
		}
		System.out.println(stack.size());
		br.close();
	}

}
