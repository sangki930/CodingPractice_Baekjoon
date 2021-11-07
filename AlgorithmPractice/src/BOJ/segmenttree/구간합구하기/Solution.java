package BOJ.segmenttree.구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer,Integer> map = new HashMap<>();
		String input[]=br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), k = Integer.parseInt(input[2]);
		int arr[]=new int[n+1];
		for(int i=1;i<n+1;i++) {
			arr[i]+=Integer.parseInt(br.readLine());
		}
		for(int i=0;i<k;i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]), b=Integer.parseInt(input[1]), c= Integer.parseInt(input[2]);
			if(a==1) {
				map.put(b, c);
			}else if(a==2) {
				
			}
		}
		
		br.close();
	}
}
