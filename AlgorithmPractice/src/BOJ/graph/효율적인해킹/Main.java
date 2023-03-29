package BOJ.graph.효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// �ð��ʰ�
public class Main {

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] input = br.readLine().split(" ");
    	int n  = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
    	Map<Integer,LinkedList<Integer>> graph = new HashMap<>();
    	
    	for(int i=0;i<m;i++) {
    		input = br.readLine().split(" ");
    		int a = Integer.parseInt(input[0]), b= Integer.parseInt(input[1]);
//    		ArrayList<Integer> arr1 = graph.getOrDefault(a, new ArrayList<>());
    		LinkedList<Integer> arr2 = graph.getOrDefault(b, new LinkedList<>());
//    		arr1.add(b);
    		arr2.offer(a);
//    		graph.put(a, arr1);
    		graph.put(b, arr2);
    	}
    	int len = 0;
    	StringBuilder answer=new StringBuilder();
    	int[] arr = new int[n+1];
    	int max = 0;
    	for(int i=1;i<=n;i++) {
    		int cnt = bfs(i,n,graph);
    		arr[i]=cnt;
    		max = Math.max(cnt,max);
//    		if(cnt>=len) {
//    			if(cnt>len) {
//    				answer = new StringBuilder();
//    				len=cnt;
//    			}
//    			answer.append(i).append(" ");
//    		}
    	}
    	for(int i=1;i<=n;i++)
    		if(max == arr[i])
    			answer.append(arr[i]+" ");
    	
    	System.out.println(answer);
    	
    	br.close();
    }
    
    public static int bfs(int i, int n, Map<Integer,LinkedList<Integer>> graph ) {
    	boolean[] visited = new boolean[n+1];
    	LinkedList<Integer> queue = new LinkedList<>();
    	queue.offer(i);
    	int cnt=0;
    	visited[i]=true;
    	while(!queue.isEmpty()) {
    		int node = queue.poll();
    		
    		for(int e : graph.getOrDefault(node, new LinkedList<>())) {
    			if(!visited[e]) {
    				cnt++;
    				visited[e]=true;
    				queue.offer(e);
    			}
    			
    		}
    	}
    	
    	return cnt;
    }
}

