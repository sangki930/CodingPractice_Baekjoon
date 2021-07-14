package BOJ.implementation.로봇청소기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int n;
	static int m;
	public static boolean isInTheMap(int r,int c) {
		if(0<=r && 0<=c && r<n && r<m)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input[]=br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int r = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);
		int d = Integer.parseInt(input[2]);
		
		int map[][]=new int[n][m];
		
		for(int i=0;i<n;i++) {
			input = br.readLine().split(" ");
			for(int j=0;j<m;j++)
				map[i][j] = Integer.parseInt(input[j]);
		}
		
//		현재 위치를 청소한다.
//		현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
//		왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
//		왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
//		네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//		네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
		
		//0 : 북쪽, 1 : 동쪽, 2: 남쪽, 3 : 서쪽
		while(true) {
			
			boolean flag=false;
			map[r][c]=-1; // 현재 위치를 청소
			
			loop : for(int i=0;i<4;i++) {
				
				if(i!=0)
					d = (d==0)?3:(--d);
				
				switch(d) {
				//북	
				case 0->{
					if(isInTheMap(r-1, c) && map[r-1][c]==0) {
						--r;
						flag=true;
						break loop;
					}
				}
				//서
				case 3->{
					
				}
				//남
				case 2->{
					
				}
				//동
				case 1->{
					
				}
				
				}
			}
			if(flag)
				continue;
			
			if(d==0)
				break;
		}
		
		bw.close();
		br.close();
	}

}
