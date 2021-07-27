package BOJ.unionfind.교수님은기다리지않는다;

import java.io.*;
import java.util.*;

public class Main{
    static int[] parents = new int[1000000];
    static long[] weight = new long[1000000];
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        while(
            (n=Integer.parseInt(st.nextToken()))+(m=Integer.parseInt(st.nextToken()))!=0
        ){
            for(int i=0;i<n;i++){
                parents[i]=-1;
                weight[i]=0;
            }
            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                boolean flag = st.nextToken().charAt(0)=='!';
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                int pa = find(a);
                int pb = find(b);
                if(flag){
                    long w = Integer.parseInt(st.nextToken());
                    if(pa!=pb){
                        parents[pa]=pb;
                        weight[pa] = weight[b]-weight[a]+w;
                    }
                }else{
                    if(pa==pb)
                        sb.append((weight[a]-weight[b]));
                    else
                        sb.append("UNKNOWN");
                    sb.append("\n");
                }
            }
            st = new StringTokenizer(br.readLine());
        }
        System.out.println(sb.toString());
        br.close();
    }
    
    public static int find(int a){
        if(parents[a]<0)
            return a;
        int p = find(parents[a]);
        weight[a] += weight[parents[a]];
        return parents[a]=p;
    }
}
