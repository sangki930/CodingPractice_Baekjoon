package BOJ.bfs.토마토_another;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

	static int[][] dir = {{0,0,1},{0,0,-1},{1,0,0},{-1,0,0},{0,1,0},{0,-1,0}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(), n = sc.nextInt(), h = sc.nextInt();
		
		int[][][] tomato = new int[h][n][m];
		int[][][] dist = new int[h][n][m];
		Queue<int[]> queue = new LinkedList<>();
		boolean flag=false;
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					tomato[i][j][k]=sc.nextInt();
					if(tomato[i][j][k]==0)
						flag=true;
					else if(tomato[i][j][k]==1)
						queue.offer(new int[] {k,j,i});
				}
			}
		}
		if(!flag) {
			System.out.println(0);
			return ;
		}
		int answer=0;
		int max=0;
		while(!queue.isEmpty()) {
			int[] point = queue.poll();
//			System.out.println(queue);
//			tomato[point[2]][point[1]][point[0]]=1;
			max = Math.max(max,dist[point[2]][point[1]][point[0]]);
			for(int a=0;a<6;a++) {
				int nx = point[0]+dir[a][0], ny = point[1]+dir[a][1], nz = point[2]+dir[a][2];
				if(nx>=0 && ny>=0 && nz>=0 && nx<m && ny<n && nz<h && tomato[nz][ny][nx]==0 && dist[nz][ny][nx]==0) {
					queue.offer(new int[] {nx,ny,nz});
					dist[nz][ny][nx] = dist[point[2]][point[1]][point[0]] + 1;
				}
			}
		}
			
		flag=true;
		
		loop : for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(tomato[i][j][k]==0 && dist[i][j][k]==0) {
						flag=false;
						break loop;
					}
					answer=Math.max(answer, dist[i][j][k]);
				}
			}
		}
		if(!flag) answer=-1;
		System.out.println(answer);
		
	}

}
