package BOJ.queue.요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 요세푸스 문제 - 실버 4
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
		
		LinkedList<Integer> circular_list = new LinkedList<>();
		for(int i=0;i<n;i++)
			circular_list.add(i+1);
		List<String> answer = new ArrayList<>();
		int popNum = 0;
		
		while(!circular_list.isEmpty()) {
			popNum = (popNum + (k-1)) % circular_list.size();
			int popElement = circular_list.remove(popNum);
			answer.add(popElement+"");
		}
		
		System.out.printf("<%s>",String.join(", ", answer));
		
		br.close();
	}
}