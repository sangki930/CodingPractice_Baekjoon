package BOJ.hash.���ڿ�����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int answer = 0;
		Set<String> set = new HashSet<>();
		for(int i=0;i<n;i++)
			set.add(br.readLine());
		for(int i=0;i<m;i++)
			if(set.contains(br.readLine()))
				answer++;
		System.out.println(answer);
		br.close();

	}

}
