package BOJ.implementation.치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

	private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	private static LinkedList<int[]> houses = new LinkedList<>();
	private static ArrayList<int[]> chicken_shops = new ArrayList<>();
	
	static int answer = Integer.MAX_VALUE;
	static int[] sums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		
		for(int i=0;i<n;i++) {
			input = br.readLine().split(" ");
			for(int j=0;j<input.length;j++) {
				switch(input[j]) {
					case "1"->{
						houses.offer(new int[] {i,j});
					}
					case "2"->{
						chicken_shops.add(new int[] {i,j});
					}
					default->{
						
					}
						
				}
			}
		}
		sums = new int[houses.size()];
		Arrays.fill(sums,Integer.MAX_VALUE);
//		System.out.println(Arrays.toString(sums));
		combination(chicken_shops.size(),m);
//		System.out.println(Arrays.toString(sums));
//		for(int i : sums)
//			if(i==Integer.MAX_VALUE) continue;
//			else
//				answer+=i;
		System.out.println(answer);
//		combination(5,3);
//		
//		for(ArrayList<Integer> a : result)
//			System.out.println(a);
		
		br.close();
	}

	public static ArrayList<Integer> combination(int n, int r) {
		return combination(n, r, 0, new ArrayList<>());
	}

	public static ArrayList<Integer> combination(int n, int r, int idx, ArrayList<Integer> arr) {
		
		if(r==arr.size()) {
//			System.out.println(arr);
			int sum = 0;
			for(int[] house : houses) {
				int k = Integer.MAX_VALUE;
				for(int i : arr) {
					int[] chicken_shop = chicken_shops.get(i);
					int j = 0;
					int dis = Math.abs(chicken_shop[0]-house[0])+Math.abs(chicken_shop[1]-house[1]);
					k = Math.min(dis, k);
				}
				sum+=k;
			}
			answer = Math.min(answer, sum);
			return null;
		}
		ArrayList<Integer> list = new ArrayList<>(arr);
		for(int i=idx;i<n;i++) {
			list.add(i);
//			System.out.println(list);
			combination(n,r,i+1,new ArrayList<>(list));
			list.remove(new Integer(i));
		}

		return null;
	}

}