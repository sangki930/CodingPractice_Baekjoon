package BOJ.bruteforce.단어나누기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] st = new String[3];

		for (int i = 1; i < input.length() - 1; ++i) {
			for (int j = i + 1; j < input.length(); ++j) {

				st[0] = input.substring(0, i);
				st[1] = input.substring(i, j);
				st[2] = input.substring(j, input.length());

				reverse(st);

			}
		}

		Collections.sort(list); // 정렬

		System.out.println(list.get(0));

	}


	public static void reverse(String[] a) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 3; ++i) {
			for (int j = a[i].length() - 1; j >= 0; --j) {

				sb.append(Character.toString(a[i].charAt(j)));
			}
		}

		list.add(sb.toString());
		sb.setLength(0);
	}

}
