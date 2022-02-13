package BOJ.graph.상근이의_여행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	
	static int[] parents;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<t;i++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
			boolean[] v = new boolean[n+1];
			for(int j=0;j<m;j++) {
				input = br.readLine().split(" ");
				int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]); // 입력받기 위한 변수
			}
			System.out.println(n-1); //결국에는 최소 신장 트리의 성질에 의해 노드의 개수-1개가 최솟값이다.
		}
		br.close();
		
	}

}
