package BOJ.unionfind.집합의_표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {

	static int[] parent;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]), m = Integer.parseInt(tmp[1]);
		parent = IntStream.range(0, n+1).toArray();
		for(int i=0;i<m;i++) {
			tmp = br.readLine().split(" ");
			int job = Integer.parseInt(tmp[0]), a = Integer.parseInt(tmp[1]), b = Integer.parseInt(tmp[2]);
			switch(job) {
				case 0->{
					union(a,b);
				}
				case 1->{
					System.out.println(isSameParent(a, b));
				}
				default->{}
			}
		}
		
		br.close();

	}
	
	// x의 부모 찾기
	public static int find(int x) {
		if(x==parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	// 합집합
	public static void union(int x, int y) {
		x = find(x);
        y = find(y);
        if(x != y) {
            parent[y] = x;
        }
	}

	// 부모가 같은 지 판별
	public static String isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) return "YES";
		return "NO";
	}
}
