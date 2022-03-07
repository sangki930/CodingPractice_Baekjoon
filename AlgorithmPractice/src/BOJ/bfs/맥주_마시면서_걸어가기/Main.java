package BOJ.bfs.맥주_마시면서_걸어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Point{
	int x,y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

// 플로이드-와샬 알고리즘
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] dist = new int[n+2][n+2];
			boolean[][] v = new boolean[n+2][n+2];
			List<Point> list = new ArrayList<>();
			String[] input;
			
			for(int j=0;j<=n+1;j++) {
				input = br.readLine().split(" ");
				list.add(new Point(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
			}
			
			for(int j=0;j<=n+1;j++) {
				for(int k=0;k<=n+1;k++) {
					Point p1 = list.get(j), p2 = list.get(k);
					dist[j][k] = Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
					if(dist[j][k]<=50*20) { // 맥주 마시면서 갈 수 있는 지
						v[j][k]=true;
					}
				}
			}
			
			for(int j=0;j<=n+1;j++)
				for(int k=0;k<=n+1;k++)
					for(int l=0;l<n+1;l++)
						if(v[k][j] && v[j][l])
							v[k][l]=true;
			
			System.out.println(v[n+1][0] ? "happy" : "sad");
		}
		
		br.close();
	}

}
