package BOJ.bfs.구슬_탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class State{
	
}

//[13459] 구슬 탈출 (Gold2)
public class Main {

	static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		char[][] map = new char[n][m];
		for(int i=0;i<n;i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				map[i][j] = tmp[j];
			}
		}
		
		
		
		br.close();
	}

}
