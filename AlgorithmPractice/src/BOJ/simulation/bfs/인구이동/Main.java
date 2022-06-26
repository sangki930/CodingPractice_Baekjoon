package BOJ.simulation.bfs.인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point{
	int x,y;

	/**
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

public class Main {

	static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]), l = Integer.parseInt(input[1]), r = Integer.parseInt(input[2]);
		
		int[][] arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			input = br.readLine().split(" ");
			for(int j=0;j<input.length;j++)
				arr[i][j] = Integer.parseInt(input[j]);
		}
		int answer = 0, cnt = 0;
		while(true) {
			boolean[][] visited = new boolean[n][n];
			int sum = 0;
			cnt = 0;
			
			boolean isMove = false;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(visited[i][j]) continue;
					Queue<Point> queue = new LinkedList<>();
					LinkedList<Point> list = new LinkedList<>();
					queue.offer(new Point(i,j)); // x : 행, y : 열
					list.offer(new Point(i,j));
					visited[i][j] = true;
					sum = arr[i][j];
					while(!queue.isEmpty()) {
						Point point = queue.poll();
						
						for(int k=0;k<4;k++) {
							
							int nx = point.x + dx[k], ny = point.y + dy[k];
							if(nx>=0 && ny>=0 && nx<n && ny<n) {
								int diff_tmp = Math.abs(arr[point.x][point.y]-arr[nx][ny]);
								if(!visited[nx][ny]) {
									
									if(l<=diff_tmp && diff_tmp<=r) {
										queue.offer(new Point(nx,ny));
										list.offer(new Point(nx,ny));
										visited[nx][ny] = true;
										sum+=arr[nx][ny];
									}
								}
							}
						}
					}

					for(Point point : list)
						arr[point.x][point.y] = (sum/list.size());
					if(list.size()>1) isMove = true;
					
				}
			}
			
//			for(int i=0;i<n;i++)
//				System.out.println(Arrays.toString(arr[i]));
//			System.out.println("==========================");
			if(!isMove) break;
				answer++;
		
		}
		
		System.out.println(answer);
		
		br.close();
	}

}
