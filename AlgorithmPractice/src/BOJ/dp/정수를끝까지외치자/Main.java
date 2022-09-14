package BOJ.dp.정수를끝까지외치자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Data{
	int num;
	int player;

	public Data(int num, int player) {
		super();
		this.num = num;
		this.player = player;
	}

	@Override
	public String toString() {
		return "Data [num=" + num + ", player=" + player + "]";
	}
	
}

// 미완
public class Main {

	static boolean[] isBanned;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		isBanned = new boolean[n+1];
		for(int i=0;i<input.length;i++) {
			int num = Integer.parseInt(input[i]);
			isBanned[num] = true;
		}
		
		Queue<Data> queue = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		
		for(int i=1;i<=k;i++) {
			if(!isBanned[i])
				queue.offer(new Data(i,0));
		}
		
		while(!queue.isEmpty()) {
			Data data = queue.poll();
			int num = data.num;
			boolean flag = false;
			for(int i=num+1;i<=num+k;i++) {
				if(!isBanned[i] && i<=n) {
					flag = true;
					queue.offer(new Data(i,data.player==1?0:1));
					System.out.println(new Data(i,data.player==1?0:1));
				}
			}
			if(!flag) {
				set.add(data.player);
			}
		}
		
		System.out.println(set);
		
        br.close();
	}

}