package BOJ.implementation._2048_Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

// 골드2 / 2048(Easy) / SW 역량테스트 기출문제
public class Main {

	static int[][] map;
	static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		func(4, 5, new ArrayList<>());

		int[][] t = { 
				{ 8, 4, 8, 2 }, 
				{ 0, 4, 0, 0 }, 
				{ 16, 0, 0, 0 }, 
				{ 0, 8, 2, 0 }, 
				};
		goUp(t);
		
		for (int[] q : t)
			System.out.println(Arrays.toString(q));
//		System.out.println(result.size());
//		for(ArrayList<Integer> arr : result)
//			System.out.println(arr);
//		for(ArrayList<Integer> arr : result) {
//			int[][] test = arrayCopy(map);
////			System.out.println("---------------------------------"+arr);
//			for(int i : arr) {
//				switch(i) {
//					case 0->{
//						goLeft(test);
//					}
//					case 1->{
//						goRight(test);
//					}
//					case 2->{
//						goUp(test);
//					}
//					case 3->{
//						goDown(test);
//					}
//				}
////				if(answer==64) {
////					for(int[] ss : test)
////						System.out.println(Arrays.toString(ss));
////					System.out.println("=======================>");
////				}
//				
//			}
//			
//			
//		}
		System.out.println(answer);

		br.close();
	}
	
	public static int[][] arrayCopy(int[][] arr){
		int[][] ret = new int[arr.length][arr[0].length];
		for(int i=0;i<arr.length;i++) {
			ret[i] = arr[i].clone();
		}
		return ret;
	}

	public static void func(int n, int r, ArrayList<Integer> arr) {
		if (arr.size() == r)
			return;
		ArrayList<Integer> list = new ArrayList<>(arr);
		for (int i = 0; i < n; i++) {
			list.add(i);
			if (list.size() == r) {
				result.add(new ArrayList<>(list));
			}
			func(n, r, list);
			list.remove(list.size()-1);
		}

	}

	public static int[][] goLeft(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			int[] tmp = new int[arr[0].length];
			int k = 0;

			LinkedList<Integer> queue = new LinkedList<>();
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0)
					continue;
				if (queue.isEmpty()) {
					queue.offer(arr[i][j]);
				} else {
					if (queue.peekLast() == arr[i][j]) {
						queue.offer(queue.pollLast() + arr[i][j]);
					} else
						queue.offer(arr[i][j]);
				}
			}
			while (!queue.isEmpty()) {
				tmp[k] = queue.poll();
				answer = Math.max(tmp[k], answer);
				k++;
			}
			arr[i] = tmp;
		}

		return arr;
	}

	public static int[][] goRight(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			int[] tmp = new int[arr[0].length];
			int k = arr[0].length-1;

			LinkedList<Integer> queue = new LinkedList<>();
			for (int j = arr[0].length-1; j >= 0; j--) {
				if (arr[i][j] == 0)
					continue;
				if (queue.isEmpty()) {
					queue.offerFirst(arr[i][j]);
				} else {
					if (queue.peekFirst() == arr[i][j]) {
						queue.offerFirst(queue.pollFirst() + arr[i][j]);
					} else
						queue.offerFirst(arr[i][j]);
				}
			}
			while (!queue.isEmpty()) {
				tmp[k] = queue.pollLast();
				answer = Math.max(tmp[k], answer);
				k--;
			}
			arr[i] = tmp;
		}

		return arr;
	}
	
	public static int[][] goUp(int[][] arr){
		
		for(int i=0;i<arr[0].length;i++) {
			LinkedList<Integer> queue = new LinkedList<>();
			for(int j=0;j<arr.length;j++) {
				if(arr[j][i]==0) continue;
				if(queue.isEmpty()) queue.offer(arr[j][i]);
				else {
					if(queue.peekLast()==arr[j][i])
						queue.offer(arr[j][i]+queue.pollLast());
					else
						queue.offer(arr[j][i]);
				}
			}
			
			for(int j=0;j<arr.length;j++) {
				if(!queue.isEmpty())
					arr[j][i] = queue.poll();
				else
					arr[j][i] = 0;
				answer = Math.max(answer, arr[j][i]);
			}
			
		}
		
		return arr;
	}
	
	public static int[][] goDown(int[][] arr){
			
			for(int i=0;i<arr[0].length;i++) {
				LinkedList<Integer> queue = new LinkedList<>();
				for(int j=arr.length-1;j>=0;j--) {
					if(arr[j][i]==0) continue;
					if(queue.isEmpty()) queue.offerFirst(arr[j][i]);
					else {
						if(queue.peek()==arr[j][i])
							queue.offerFirst(arr[j][i]+queue.pollFirst());
						else
							queue.offerFirst(arr[j][i]);
					}
				}
				
				for(int j=arr.length-1;j>=0;j--) {
					if(!queue.isEmpty())
						arr[j][i] = queue.pollLast();
					else
						arr[j][i] = 0;
					answer = Math.max(answer, arr[j][i]);
				}
				
			}
			
			return arr;
		}
}