package BOJ.implementation._2048_Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

class Data{
	int num; // 수
	boolean flag; // 결합한 적 있는 지
	public Data(int num, boolean flag) {
		super();
		this.num = num;
		this.flag = flag;
	}
	
}

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

		for(ArrayList<Integer> arr : result) {
			int[][] test = arrayCopy(map);

			for(int i : arr) {
				switch(i) {
					case 0->{
						goLeft(test);
					}
					case 1->{
						goRight(test);
					}
					case 2->{
						goUp(test);
					}
					case 3->{
						goDown(test);
					}
				}
				
			}
			
			
		}
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

			LinkedList<Data> queue = new LinkedList<>();
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0)
					continue;
				if (queue.isEmpty()) {
					queue.offer(new Data(arr[i][j],false));
				} else {
					if (queue.peekLast().num == arr[i][j] && !queue.peekLast().flag) {
						queue.offer(new Data(queue.pollLast().num + arr[i][j],true));
					} else
						queue.offer(new Data(arr[i][j],false));
				}
			}
			while (!queue.isEmpty()) {
				tmp[k] = queue.poll().num;
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

			LinkedList<Data> queue = new LinkedList<>();
			for (int j = arr[0].length-1; j >= 0; j--) {
				if (arr[i][j] == 0)
					continue;
				if (queue.isEmpty()) {
					queue.offerFirst(new Data(arr[i][j],false));
				} else {
					if (queue.peekFirst().num == arr[i][j] && !queue.peekFirst().flag) {
						queue.offerFirst(new Data(queue.pollFirst().num + arr[i][j],true));
					} else
						queue.offerFirst(new Data(arr[i][j],false));
				}
			}
			while (!queue.isEmpty()) {
				tmp[k] = queue.pollLast().num;
				answer = Math.max(tmp[k], answer);
				k--;
			}
			arr[i] = tmp;
		}

		return arr;
	}
	
	public static int[][] goUp(int[][] arr){
		
		for(int i=0;i<arr[0].length;i++) {
			LinkedList<Data> queue = new LinkedList<>();
			for(int j=0;j<arr.length;j++) {
				if(arr[j][i]==0) continue;
				if(queue.isEmpty()) queue.offer(new Data(arr[j][i],false));
				else {
					if(queue.peekLast().num==arr[j][i] && !queue.peekLast().flag)
						queue.offer(new Data(arr[j][i]+queue.pollLast().num,true));
					else
						queue.offer(new Data(arr[j][i],false));
				}
			}
			
			for(int j=0;j<arr.length;j++) {
				if(!queue.isEmpty())
					arr[j][i] = queue.poll().num;
				else
					arr[j][i] = 0;
				answer = Math.max(answer, arr[j][i]);
			}
			
		}
		
		return arr;
	}
	
	public static int[][] goDown(int[][] arr){
			
			for(int i=0;i<arr[0].length;i++) {
				LinkedList<Data> queue = new LinkedList<>();
				for(int j=arr.length-1;j>=0;j--) {
					if(arr[j][i]==0) continue;
					if(queue.isEmpty()) queue.offerFirst(new Data(arr[j][i],false));
					else {
						if(queue.peek().num==arr[j][i] && !queue.peek().flag)
							queue.offerFirst(new Data(arr[j][i]+queue.pollFirst().num,true));
						else
							queue.offerFirst(new Data(arr[j][i],false));
					}
				}
				
				for(int j=arr.length-1;j>=0;j--) {
					if(!queue.isEmpty())
						arr[j][i] = queue.pollLast().num;
					else
						arr[j][i] = 0;
					answer = Math.max(answer, arr[j][i]);
				}
				
			}
			
			return arr;
		}
}