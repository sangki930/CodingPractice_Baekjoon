package BOJ.implementation.쉽게푸는문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i=1;i<=100;i++) {
			for(int j=1;j<=i;j++)
				list.add(i);
		}
		int answer=0;
		for(int i=a-1;i<=b-1;i++) {
			answer+=list.get(i);
		}
		System.out.println(answer);
		br.close();
	}

}
