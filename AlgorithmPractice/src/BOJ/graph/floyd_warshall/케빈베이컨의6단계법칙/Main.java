package BOJ.graph.floyd_warshall.케빈베이컨의6단계법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int INF = 999999999;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[][] arr = new int[n + 1][n + 1];
 
        // 초기값 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = INF;
 
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
        	tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
 
            arr[x][y] = arr[y][x] = 1;
        }
 
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
 
        int res = INF;
        int idx = -1;
 
        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++) {
                total += arr[i][j];
            }
 
            if (res > total) {
                res = total;
                idx = i;
            }
        }
        System.out.println(idx);
		br.close();
	}
}