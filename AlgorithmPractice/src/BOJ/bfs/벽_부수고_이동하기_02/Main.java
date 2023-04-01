package BOJ.bfs.벽_부수고_이동하기_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Data{
    int x,y;
    int dist;
    int cnt;
    public Data(int x, int y, int dist,int cnt) {
        this.x=x;
        this.y=y;
        this.dist=dist;
        this.cnt=cnt;
    }
}

public class Main {

    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), k = Integer.parseInt(input[2]);
        String[] map = new String[n];

        boolean[][][] visited = new boolean[k+1][n][m];
        int answer = Integer.MAX_VALUE;
        boolean flag=false;
        for(int i=0;i<n;i++) {
            map[i] = br.readLine();
        }

        LinkedList<Data> queue = new LinkedList<>();
        queue.offer(new Data(0,0,1,0));
        while(!queue.isEmpty()) {
            Data data = queue.poll();
            if(data.y==n-1 && data.x==m-1) {
                answer = Math.min(data.dist, answer);
                flag=true;
                continue;
            }
            if(visited[data.cnt][data.y][data.x])
                continue;
            visited[data.cnt][data.y][data.x]=true;
            for(int i=0;i<4;i++) {
                int nx = data.x+dx[i];
                int ny = data.y+dy[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n) {
                    char ch = map[ny].charAt(nx);
                    if(data.cnt<k) {
                        if(ch=='0')
                            queue.offer(new Data(nx,ny,data.dist+1,data.cnt));
                        else
                            queue.offer(new Data(nx,ny,data.dist+1,data.cnt+1));
                    }else if(data.cnt==k && ch=='0') {
                        queue.offer(new Data(nx,ny,data.dist+1,data.cnt));
                    }
                }
            }
        }
        if(!flag) answer=-1;
        System.out.println(answer);

        br.close();
    }
}
