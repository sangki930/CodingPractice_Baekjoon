package BOJ.bruteforce.감소하는수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
public class Main {
 
	static Set<Long> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		func(9,"");
		List<Long> list = new ArrayList<>(set);
		list.sort((a,b)->Long.compare(a, b));
		System.out.println(n>=list.size()?-1:list.get(n));
		br.close();
	}
	
	public static void func(int m,String str) {
		if(m<0) return ;	
		for(int i=m;i>=0;i--) {
			String tmp = new String(str)+i;
			func(i-1,tmp);
			set.add(Long.parseLong(tmp));
		}
	}
 
}
