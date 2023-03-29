package BOJ.dp.끝까지외친정수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		boolean[] isBanned = new boolean[n+1];
		for(String s : input)
			isBanned[Integer.parseInt(s)] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(1);
		Set<Integer> set = new HashSet<>();
		while(!queue.isEmpty()) {
			int m = queue.poll();
			boolean flag = false;
			for(int i=m+1;i<=m+k;i++) {
				if(!isBanned[i])
					queue.offer(i);
			}
		}
		
		br.close();
	}

}
