package BOJ.graph.topologySort.줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		int[] degrees = new int[n+1]; // �� �л����� ������ ����
		Map<Integer,LinkedList<Integer>> graph = new HashMap<>();
		for(int i=0;i<m;i++) {
			input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]), e = Integer.parseInt(input[1]);
			LinkedList<Integer> arr = graph.getOrDefault(s, new LinkedList<>());
			arr.offer(e);
			graph.put(s,arr);
			degrees[e]++;
		}
		
		LinkedList<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder(); //�ᱣ��
		for(int i=1;i<=n;i++) {
			if(degrees[i]==0)
				queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int student = queue.poll();
			sb.append(student+" ");
			LinkedList<Integer> arr = graph.getOrDefault(student, new LinkedList<>());
			for(int i :arr) {
				degrees[i]--;
				if(degrees[i]==0)
					queue.offer(i);
			}
		}

		System.out.println(sb);
		br.close();
	}

}
