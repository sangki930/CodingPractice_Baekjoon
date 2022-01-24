package BOJ.문자열.컬러볼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Pair{
	int c;
	int s;
	int id;
	long sum;
	public Pair(int c, int s,int id) {
		super();
		this.c = c;
		this.s = s;
		this.id=id;
	}

}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Pair[] pairs = new Pair[n];
		int[] save = new int[200001];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int c = Integer.parseInt(input[0]), s = Integer.parseInt(input[1]);
			pairs[i] = new Pair(c, s, i);
		}
		long[] result = new long[n];
		Arrays.sort(pairs, (a, b) -> {
			if (a.s == b.s)
				return Integer.compare(a.c, b.c);
			return Integer.compare(a.s, b.s);
		});

		int sum = 0;
		for (int i = 0, j = 0; i < pairs.length; i++) {
			Pair current = pairs[i];
			while (pairs[j].s < current.s) {
				sum += pairs[j].s;
				save[pairs[j].c] += pairs[j].s;
				j++;
			}
			result[current.id] = sum - save[current.c];
		}

		for (long r : result)
			System.out.println(r);

		br.close();
	}

}