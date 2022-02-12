package BOJ.graph.Ư���Ÿ���_����_ã��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);//������ ����
        int M = Integer.valueOf(input[1]);//������ ����
        int K = Integer.valueOf(input[2]);//�ִܰŸ�
        int X = Integer.valueOf(input[3]);//��ߵ���
        
        Map<Integer,LinkedList<Integer>> graph = new TreeMap<>();
        
        for(int i=0;i<M;i++){
            input = br.readLine().split(" ");
            int start = Integer.valueOf(input[0]);
            int end = Integer.valueOf(input[1]);
            
            LinkedList<Integer> tmp = graph.getOrDefault(start,new LinkedList<Integer>());
            tmp.offer(end);
            graph.put(start,tmp);
        }
        int dis[] = new int[N+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);
        dis[X]=0;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int t : graph.getOrDefault(now,new LinkedList<Integer>())){
            	if(dis[t]>=dis[now]+1){
                     dis[t]=dis[now]+1;
                    queue.offer(t);
                }
            }
            
        }
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<dis.length;i++) {
        	if(dis[i]==K)
        	{
        		answer.append(i+"\n");
        	}
        }
        if(answer.isEmpty())
        	System.out.println(-1);
        else
        	System.out.println(answer);
        br.close();
	}

}