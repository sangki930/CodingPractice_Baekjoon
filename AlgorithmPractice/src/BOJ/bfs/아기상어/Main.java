package BOJ.bfs.아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Point{
	int x,y,dis;

	public Point(int x, int y, int dis) {
		super();
		this.x = x;
		this.y = y;
		this.dis = dis;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", dis=" + dis + "]";
	}
	
}

public class Main {

	static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
	static int n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
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
		LinkedList<Point> queue1 = new LinkedList<>();//외부 큐
		queue1.offer(new Point(s_x,s_y,0));
		
		while(true) {
			
			Point point = queue1.poll();
			
			
			
			if(true) break;
		}
		
		int a=-2,b=-2;

		br.close();
	}
	
	public void bfs(Point input, int[][] arr) {
		LinkedList<Point> queue = new LinkedList<>();//내부 큐
		queue.offer(input);
		boolean[][] visited = new boolean[n][n];
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = point.x+dx[i], ny = point.y+dy[i];
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue; // 장외이거나 방문했다면
				
			}
		}
	}

}
