package BOJ.bruteforce.¸®¸ðÄÁ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

	static Set<Integer> button = new HashSet<>(Set.of(0,1,2,3,4,5,6,7,8,9));
	static int len = 0;
	static List<String> list = new LinkedList<>();
	static int n = 0,answer = 500001;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input=br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(br.readLine());
		len = (n+"").length();
		answer = Math.min(answer,Math.abs(n-100));

		if(m>0) {
			Arrays.stream(br.readLine().split(" ")).forEach(i->button.remove(new Integer(Integer.parseInt(i))));
		}
		if(!button.isEmpty())
			func("",0);

		System.out.println(answer);
		br.close();
	}
	
	static void func(String num,int level) {

		for(int i : button) {
			String tmp = new String(num)+i;
			answer = Math.min(answer, Math.abs(n - Integer.parseInt(tmp)) + tmp.length());
			if(tmp.length()<6)
			func(tmp,level+1);
		}
	}

}
