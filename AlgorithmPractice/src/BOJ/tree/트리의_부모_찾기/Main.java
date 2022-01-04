package BOJ.tree.트리의_부모_찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;


public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.valueOf(br.readLine());
        Map<Integer,ArrayList<Integer>> tree = new TreeMap<>();
        
        for(int i=0;i<n-1;i++){
            String[] tmp = br.readLine().split(" ");
            int s = Integer.valueOf(tmp[0]);
            int e = Integer.valueOf(tmp[1]);
            
            ArrayList<Integer> tmplist1=tree.getOrDefault(s,new ArrayList<>());
            ArrayList<Integer> tmplist2=tree.getOrDefault(e,new ArrayList<>());
            
            tmplist1.add(e);
            tmplist2.add(s);
            
            tree.put(s,tmplist1);
            tree.put(e,tmplist2);
        }
     
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean visited[]=new boolean[n+1];
        int result[]=new int[n+1];
        result[1]=1;
        while(!queue.isEmpty()){
            int a = queue.poll();
            if(visited[a])
            	continue;
            visited[a]=true;
            for(int ele : tree.getOrDefault(a,new ArrayList<>())){
            	if(result[ele]==0) {
            		result[ele]=a;
                    queue.offer(ele);
            	}
                
            }
        }
        
        for(int i=2;i<result.length;i++)
           bw.write(""+result[i]+"\n");
        
        bw.close();
        br.close();
    } 
}
