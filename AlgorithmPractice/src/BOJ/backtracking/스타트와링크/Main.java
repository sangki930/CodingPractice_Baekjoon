package BOJ.backtracking.스타트와링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];

		int[] start = new int[n];
		int[] link = new int[n];
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		for (int i = 1; i < 1 << n; i++) {
			int[] value = new int[n];
			int count = 0;

			int bit = i;
			for (int j = 0; bit != 0; j++, bit >>= 1) {
				if ((1 & bit) == 0) {
					continue;
				}
				value[j] = 1;
			}

			for (int k = 0; k < n; k++) {
				if (value[k] == 1) {
					count++;
				}
			}

			// ��������� ��� ���ϱ�

			// ���� �ο��� ��Ȯ�� 2�� ���������� �� �� ���������� ���� �� �� �ִ�.
			if (count != n / 2)
				continue;

			int start_sum = 0;
			int link_sum = 0;
			int start_cnt = 0;
			int link_cnt = 0;
			// value[] ���� 1�̸� ��ŸƮ��, 0�̸� link ���� �ȴ�.
			for (int k = 0; k < n; k++) {
				if (value[k] == 1) {
					// start_cnt�� 0���� ��ŸƮ ���� ����� ���ö����� 1�� �����Ѵ�.
					start[start_cnt++] = k;
				} else {
					// link_cnt�� 0���� ��ŸƮ ���� ����� ���ö����� 1�� �����Ѵ�.
					link[link_cnt++] = k;
				}
			}

			// ������ ���� �� �ִ� ������ �� ���Ѵ�.
			// (1,1) (2,2) ���� �߻��� �� ���� 0�̹Ƿ� ���� ������ ������ �ʾҴ�.
			for (int x = 0; x < n / 2; x++) {
				for (int y = 0; y < n / 2; y++) {
					start_sum += arr[start[x]][start[y]];
					link_sum += arr[link[x]][link[y]];
				}
			}
			// �ּڰ� ����
			min = Math.min(Math.abs(start_sum - link_sum), min);

		}

		System.out.println(min);
	}

}
