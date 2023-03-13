package BOJ.bfs.±³È¯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Data{
	String str;
	int k;
	public Data(String str, int k) {
		this.str=str;
		this.k=k;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int k = Integer.parseInt(tmp[1]);
		int len = tmp[0].length();
		LinkedList<Data> queue = new LinkedList<>();
		queue.offer(new Data(tmp[0],0));
		boolean[][] visited = new boolean[1000001][k+1];
		int answer = -1;
		visited[Integer.parseInt(tmp[0])][0] = true;
		while(!queue.isEmpty()) {
			Data data = queue.poll();
			if(data.k==k) {
				answer = Math.max(answer, Integer.parseInt(data.str));
				continue;
			}
			for(int i=0;i<len-1;i++) {
				for(int j=i+1;j<len;j++) {
					String num = new String(data.str);
					char[] ch = num.toCharArray();
//					if(ch[i]=='0' || ch[j]=='0') continue;
					char c = ch[j];
					ch[j] = ch[i];
					ch[i] = c;
					num = new String(ch);
					if(ch[0]=='0') continue;
					int next = Integer.parseInt(num);
					if(!visited[next][data.k+1] && data.k+1<=k) {
						queue.offer(new Data(new String(ch),data.k+1));
						visited[next][data.k+1] = true;
					}
					
				}
			}
		}
		
		System.out.println(answer);
		
		br.close();
	}

}
