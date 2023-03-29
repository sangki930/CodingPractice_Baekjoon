package BOJ.dijkstra.최소비용구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int x;
    int v;
    public Node(int x, int v){
        this.x=x;
        this.v=v;
    }
}

class Data{
    int e;
    long dis;
    int level;
    int p;

    public Data(int e, long dis, int level) {
        this.e = e;
        this.dis = dis;
        this.level = level;
    }

    public Data(int e, long dis, int level,int p) {
        this.e = e;
        this.dis = dis;
        this.level = level;
        this.p = p;
    }
}
public class Main {

    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];

        for(int i=0;i<=n;i++)
            graph[i] = new ArrayList<>();
        String[] tmp;
        for(int i=0;i<m;i++){
            tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]);
            int e = Integer.parseInt(tmp[1]);
            int v = Integer.parseInt(tmp[2]);
            graph[s].add(new Node(e,v));
//            graph[e].add(new Node(s,v));
        }
        tmp = br.readLine().split(" ");
        int a = Integer.parseInt(tmp[0]), b = Integer.parseInt(tmp[1]);
        PriorityQueue<Data> pq = new PriorityQueue<>(
                (o1,o2)->{
                    if(o1.dis==o2.dis)
                        return Integer.compare(o1.e,o2.e);
                    return Long.compare(o1.dis,o2.dis);
                }
        );
        long[] dis = new long[n+1];
        int[] parents = new int[n+1];
        Arrays.fill(dis,Long.MAX_VALUE-Integer.MAX_VALUE);
        dis[a] = 0;
        parents[a] = -1;


        pq.offer(new Data(a,0,0, -1));
        boolean[] visited = new boolean[n+1];
        while(!pq.isEmpty()){
            Data data = pq.poll();
            if(visited[data.e]) continue;
            visited[data.e] = true;
            ArrayList<Node> arr = graph[data.e];
            for(Node node : arr){
                int x = node.x;

                if(dis[x]>dis[data.e]+ node.v){
                    dis[x] = dis[data.e]+node.v;
                    pq.offer(new Data(x,dis[data.e]+node.v, data.level+1,data.e));
                    parents[x] = data.e;
                }
            }

        }
        System.out.println(dis[b]);

        int node_num = b;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(parents[node_num]!=-1){
            sb.insert(0,node_num+" ");
            node_num = parents[node_num];
            cnt++;

        }
        sb.insert(0, a+" ");
        System.out.println(cnt+1);
        System.out.println(sb);
        br.close();
    }
}
