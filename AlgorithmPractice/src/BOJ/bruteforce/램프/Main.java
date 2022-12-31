package BOJ.bruteforce.ทฅวม;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		int answer = 0;
		String[] arr = new String[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = br.readLine();
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			int zeroCnt = 0;
			for(int j=0;j<m;j++)
				if(arr[i].charAt(j)=='0') zeroCnt++;
			int sum = 0;
			if(zeroCnt<=k && zeroCnt%2==k%2) {
				for(int j=0;j<n;j++) {
					if(arr[i].equals(arr[j])) sum++;
				}
			}
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
		
		br.close();
	}

}
