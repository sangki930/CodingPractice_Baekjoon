package BOJ.bfs.연구소;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Dot {
	int x;
	int y;

	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int lab[][];
	static int tempLab[][];
	static int n, m;
	static int ans = 0;

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	static Queue<Dot> virus = new LinkedList<>();

//���� ����
	static void mapCopy(int a[][], int b[][]) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = b[i][j];
			}
		}
	}

//���̷��� ��Ʈ����(BFS)
	static void virusSpread() {
		// SpreadLab�� 3���� ������ ���� �� ���̷����� ������ ���� �������� ��Ȳ�� �����ϴ°�.
		int SpreadLab[][] = new int[n][m];
		mapCopy(SpreadLab, tempLab);
		Queue<Dot> q = new LinkedList<>(virus);

		while (!q.isEmpty()) {
			Dot d = q.poll();
			int x = d.x;
			int y = d.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// ������ ���� �ȿ� �������� ���� ������ ������ų �� �ִ�.
				if (0 <= nx && nx < m && 0 <= ny && ny < n) {
					if (SpreadLab[ny][nx] == 0) {
						SpreadLab[ny][nx] = 2;
						q.offer(new Dot(nx, ny));
					}
				}
			}
		}
		// �����ҿ� �������� ���� �κ� üũ.
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (SpreadLab[i][j] == 0)
					cnt += 1;
			}
		}
		ans = Math.max(ans, cnt);
	}

//�� �����(���ȣ�� ���)
	static void wall(int cnt) {
		// 3���� ���� �������� ��, ���̷����� ��Ʈ����.
		if (cnt == 3) {
			virusSpread();
			return;
		}
		// �� ����� �κ�.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tempLab[i][j] == 0) {
					tempLab[i][j] = 1;
					wall(cnt + 1);
					// ��� ����� ���� �־���ϹǷ� ������ 1�� 0���� �ٲپ��ִ� ��Ȱ
					tempLab[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		lab = new int[n][m];
		tempLab = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				lab[i][j] = sc.nextInt();
				if (lab[i][j] == 2) {
					virus.offer(new Dot(j, i));
				}
			}
		}
		// �����ҿ��� 0�� �κ��� ��� ���� ������ �ϹǷ� ������ ���� ����.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (lab[i][j] == 0) {
					mapCopy(tempLab, lab);
					tempLab[i][j] = 1;
					wall(1);
					tempLab[i][j] = 0;
				}
			}
		}
		System.out.printf("%d\n", ans);
		sc.close();
	}
}
