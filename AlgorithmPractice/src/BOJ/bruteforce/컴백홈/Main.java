package BOJ.bruteforce.ÄÄ¹éÈ¨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
	static int answer = 0;
	static int r,c,k;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		r = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);
		k=Integer.parseInt(input[2]);
		char[][] map = new char[r][];
		for(int i=0;i<r;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		dfs(map,r-1,0,1);
		System.out.println(answer);
		br.close();
	}

	public static void dfs(char[][] map,int x, int y,int dis) {
		
		if(dis==k) {
			if(x==0 && y==c-1) answer++;
			return;
		}
		
		map[x][y] = 'X';
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i], ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<r && ny<c && map[nx][ny]!='X' && map[nx][ny]!='T') {
				char[][] tmp = copy(map);
				dfs(tmp,nx,ny,dis+1);
			}
			
		}
	}

	public static char[][] copy(char[][] map){
		int row = map.length, col = map[0].length;
		char[][] ret = new char[row][col];
		for(int i=0;i<row;i++)
			ret[i] = map[i].clone();
		return ret;
	}
}
