package BOJ.backtracking.줄어드는_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

	static List<Long> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		// n<=1000000
		for(int i=0;i<=9;i++)
			func(i,0,10,"");
		
		list = new ArrayList<>(new HashSet<>(list));
		list.sort((a,b)->Long.compare(a, b));
		if(n>list.size()) {
			System.out.println(-1);
		}else
			System.out.println(list.get(n-1));
		
		br.close();
	}
	
	public static void func(int start, int idx, int limit, String p) {
		
		for(int i=start;i>=0;i--) {
			list.add(Long.parseLong(p+i));
			func(i-1,idx+1,limit,p+i);
		}
		
	}
	
}
