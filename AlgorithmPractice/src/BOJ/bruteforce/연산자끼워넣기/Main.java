package BOJ.bruteforce.연산자끼워넣기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static int MAX = Integer.MIN_VALUE;	// �ִ� 
	public static int MIN = Integer.MAX_VALUE;	// �ּڰ� 
	public static int[] operator = new int[4];	// ������ ���� 
	public static int[] number;					// ���� 
	public static int N;						// ���� ���� 
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		N = Integer.parseInt(br.readLine());
		number = new int[N];
 
		// ���� �Է� 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
 
		// ������ �Է� 
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
 
		dfs(number[0], 1);
 
		System.out.println(MAX);
		System.out.println(MIN);
 
	}
 
	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			// ������ ������ 1�� �̻��� ���
			if (operator[i] > 0) {
 
				// �ش� �����ڸ� 1 ���ҽ�Ų��.
				operator[i]--;
 
				switch (i) {
 
				case 0->dfs(num + number[idx], idx + 1);
				case 1->dfs(num - number[idx], idx + 1);
				case 2->dfs(num * number[idx], idx + 1);
				case 3->dfs(num / number[idx], idx + 1);
 
				}
				// ���ȣ���� ����Ǹ� �ٽ� �ش� ������ ������ �����Ѵ�.
				operator[i]++;
			}
		}
	}
 
}
