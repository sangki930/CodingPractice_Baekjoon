package BOJ.bfs.아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Point{
	int x,y;
}

public class Main {

	static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int s_x=-1,s_y=-1;
		for(int i=0;i<n;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(input[j]);
				if(map[i][j]==9) {
					s_x=j;s_y=i;
				}
			}
				
		}
		
		LinkedList<Point> queue = new LinkedList<>();
		queue.offer(new Point());
		
		int a=-2,b=-2;
		
		
		
		br.close();
	}

}
