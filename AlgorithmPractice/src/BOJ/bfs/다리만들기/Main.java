package BOJ.bfs.다리만들기;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
        for(int i=0;i<n;i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        boolean[][] visited = new boolean[n][n];
        List<ArrayList<Point>> islands = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==0 || visited[i][j]) continue;
                LinkedList<Point> queue = new LinkedList<>();
                ArrayList<Point> island = new ArrayList<>();
                queue.offer(new Point(i,j));
                visited[i][j] = true;
                island.add(new Point(i,j));
                while(!queue.isEmpty()){
                    Point point = queue.poll();
                    for(int k=0;k<4;k++){
                        int nx = point.x+dx[k], ny = point.y+dy[k];
                        if(0<=nx && nx<n && 0<=ny && ny<n && map[nx][ny]==1 && !visited[nx][ny]){
                            queue.offer(new Point(nx,ny));
                            visited[nx][ny] = true;
                            island.add(new Point(nx,ny));
                        }
                    }
                }
                islands.add(island);
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<islands.size();i++){
            for(int j=i+1;j<islands.size();j++){
                ArrayList<Point> arr1 = islands.get(i);
                ArrayList<Point> arr2 = islands.get(j);
                for(Point p1 : arr1){
                    for(Point p2 : arr2){
                        answer = Math.min(answer, Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y)-1);
                    }
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}