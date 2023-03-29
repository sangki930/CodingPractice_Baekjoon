package BOJ.bfs.구슬_탈출_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Data{
	
	int red_x;
	int red_y;
	int blue_x;
	int blue_y;
	int cnt;
	public Data(int red_x, int red_y, int blue_x, int blue_y, int cnt) {
		this.red_x = red_x;
		this.red_y = red_y;
		this.blue_x = blue_x;
		this.blue_y = blue_y;
		this.cnt = cnt;
	}
	
}

// [13460] ����Ż��2 (���1)
public class Main {

	static int n,m;
	static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1}; // ��,��,��,��
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		char[][] map = new char[n][m];
		int red_x = -1, red_y = -1;
		int blue_x = -1, blue_y = -1;
		boolean[][][] visited = new boolean[2][n][m]; // visited[0] : ��������, visited[1] : �Ķ�����
		
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				switch(map[i][j]) {
					case 'R':
						red_x = i;red_y=j;
						break;
					case 'L':
						blue_x = i;blue_y=j;
						break;
				}
			}
		}
		
		Queue<Data> queue = new LinkedList<>();
		while(!queue.isEmpty()) {
			Data data = queue.poll();
			for(int i=0;i<4;i++) {
				int new_red_x = data.red_x;
				int new_blue_x = data.blue_x;
				int new_red_y = data.red_y;
				int new_blue_y = data.blue_y;
				switch(i) {
					case 0: // ��
						if(data.blue_x>data.red_x) { // �Ķ������� ������������ �Ʒ�
							
							// �������� ���� �̵�
							while(true) {
								if(!isInMap(new_red_x-1,new_red_y)) break;
								if(map[new_red_x][new_red_y]!='#') break;
								new_red_x--;
							}
							
							// �� ���� �Ķ����� �̵�
							while(true) {
								if(!isInMap(new_blue_x-1,new_blue_y)) break;
								if(map[new_blue_x][new_blue_y]!='#') break;
								if(map[new_blue_x][new_blue_y]!='R') break;
								new_blue_x--;
							}
							
						}else if(data.blue_x<data.red_x) { // �Ķ������� ������������ ��
							
							// �Ķ����� �����̵�
							while(true) {
								if(!isInMap(new_blue_x-1,new_blue_y)) break;
								if(map[new_blue_x][new_blue_y]!='#') break;
								new_blue_x--;
							}
							
							// �� ���� �������� �����̵�
							while(true) {
								if(!isInMap(new_red_x-1,new_red_y)) break;
								if(map[new_red_x][new_red_y]!='#') break;
								if(map[new_red_x][new_red_y]!='R') break;
								new_red_x--;
							}
						}else {
							
							// ���� �߰��� ������ ��� �̵�
							// ��������
							while(true) {
								if(!isInMap(new_red_x-1,new_red_y)) break;
								if(map[new_red_x][new_red_y]!='#') break;
								new_red_x--;
							}
							
							// �Ķ�����
							while(true) {
								if(!isInMap(new_blue_x-1,new_blue_y)) break;
								if(map[new_blue_x][new_blue_y]!='#') break;
								new_blue_x--;
							}
							
						}
						break;
					case 1:
						
						break;
					case 2:
						
						break;
					case 3:
						
						break;
				
				}
			}
		}
		
		br.close();
	}
	
	public static boolean isInMap(int x, int y) {
		return (0<=x && x<n) && (0<=y && y<m);
	}

}
