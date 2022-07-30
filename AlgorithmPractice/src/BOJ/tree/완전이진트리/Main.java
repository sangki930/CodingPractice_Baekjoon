package BOJ.tree.완전이진트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 완전이진트리(9934) 실버 1
public class Main {

	static int k,num_node,idx;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		num_node = (int)Math.pow(2, k)-1;
		
		String[] input = br.readLine().split(" ");
		arr = new int[input.length];
		for(int i=0;i<input.length;i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		tree = new ArrayList[k];
		for(int i=0;i<k;i++) {
			tree[i] = new ArrayList<>();
		}
		searchTree(1,0);
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<k;i++) {
			for(int j : tree[i])
				sb.append(j).append(" ");
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}
	
	public static int searchTree(int id, int level) {
		if(level==k-1) {
			tree[level].add(arr[idx++]);
			return id;
		}
		searchTree(id*2,level+1);
		tree[level].add(arr[idx++]);
		searchTree(id*2+1,level+1);
		return id;
	}

}
