package BOJ.queue.ť2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		LinkedList<String> queue = new LinkedList<>();
		for(int i=0;i<n;i++) {
			String input[] = br.readLine().split(" ");
			String cmd = input[0];
			switch(cmd) {
				case "push"->{
					queue.offer(input[1]);
//					sb.append(input[1]).append("\n");
				}
				case "pop"->{
					if(queue.isEmpty()) sb.append("-1").append("\n");
					else
					sb.append(queue.poll()).append("\n");
				}
				case "size"->{
//					System.out.println(queue.size());
					sb.append(queue.size()).append("\n");
				}
				case "empty"->sb.append(queue.isEmpty()?1:0).append("\n");
				case "front"->{
					if(queue.isEmpty()) {
						sb.append("-1").append("\n");
					}else {
						sb.append(queue.peekFirst()).append("\n");
					}
				}
				case "back"->{
					if(queue.isEmpty()) {
						sb.append("-1").append("\n");
					}else {
						sb.append(queue.peekLast()).append("\n");
					}
				}
			}
		}
		System.out.println(sb);
		br.close();
	}

}
