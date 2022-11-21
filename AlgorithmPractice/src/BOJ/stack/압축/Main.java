package BOJ.stack.æ–√‡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// æ–√‡(∞ÒµÂ 5) [¿Á±Õ »∞øÎ]
public class Main{
	
	static boolean[] visited = new boolean[51];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		char[] ch = input.toCharArray();
		System.out.println(dfs(ch,0));
		br.close();
	}
	
	public static int dfs(char[] ch, int idx) {
		int cnt = 0;
		for(int i=idx;i<ch.length;i++) {
			if (ch[i] == '(' && !visited[i]) {
	            visited[i] = true;
	            int num = ch[i - 1] - '0';
	            cnt--;
	            cnt += num * dfs(ch, i + 1);
	        }
	        else if (ch[i] == ')' && !visited[i]) {
	            visited[i] = true;
	            return cnt;
	        }
	        else if(!visited[i]){
	            visited[i] = true;
	            cnt++;
	        }
		}
		return cnt;
	}
}
