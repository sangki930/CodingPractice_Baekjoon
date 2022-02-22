package BOJ.graph.촌수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// BFS 풀이
public class Main {

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	String[] input = br.readLine().split(" ");
    	int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
    	int m = Integer.parseInt(br.readLine());
    	Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
    	
    	for(int i=1;i<=n;i++) {
    		graph.put(i, new ArrayList<>());
    	}
    	
    	for(int i=0;i<m;i++) {
    		input = br.readLine().split(" ");
    		int p = Integer.parseInt(input[0]), s = Integer.parseInt(input[1]);
    		ArrayList<Integer> arr1 = graph.getOrDefault(p, new ArrayList<>());
    		ArrayList<Integer> arr2 = graph.getOrDefault(s, new ArrayList<>());
    		arr1.add(s);
    		arr2.add(p);
    		graph.put(p, arr1);
    		graph.put(s, arr2);
    	}
    	
    	LinkedList<Integer> queue = new LinkedList<>();
    	queue.offer(a);
    	int[] dist = new int[n+1];
    	Arrays.fill(dist, -1);
    	dist[a]=0;
//    	System.out.println(graph);
    	while(!queue.isEmpty()) {
    		int node = queue.poll();
    		for(int i : graph.getOrDefault(node, new ArrayList<>())) {
    			if(dist[i]>0) continue;
    			dist[i]=dist[node]+1;
    			queue.offer(i);
    		}
//    		System.out.println(queue);
    	}
    	System.out.println(dist[b]);
    	br.close();
    }
}
