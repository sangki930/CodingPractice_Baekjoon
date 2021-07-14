package BOJ.implementation.�κ�û�ұ�;

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
		
//		���� ��ġ�� û���Ѵ�.
//		���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž���� �����Ѵ�.
//		���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�.
//		���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���.
//		�� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���.
//		�� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ��쿡�� �۵��� �����.
		
		//0 : ����, 1 : ����, 2: ����, 3 : ����
		while(true) {
			
			boolean flag=false;
			map[r][c]=-1; // ���� ��ġ�� û��
			
			loop : for(int i=0;i<4;i++) {
				
				if(i!=0)
					d = (d==0)?3:(--d);
				
				switch(d) {
				//��	
				case 0->{
					if(isInTheMap(r-1, c) && map[r-1][c]==0) {
						--r;
						flag=true;
						break loop;
					}
				}
				//��
				case 3->{
					
				}
				//��
				case 2->{
					
				}
				//��
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
