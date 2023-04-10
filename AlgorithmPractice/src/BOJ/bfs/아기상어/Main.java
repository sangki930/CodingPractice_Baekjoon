package BOJ.bfs.�Ʊ���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Point{
    int x,y,dis;

    public Point(int x, int y, int dis) {
        super();
        this.x = x;
        this.y = y;
        this.dis = dis;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + ", dis=" + dis + "]";
    }
}
// �Ʊ���
public class Main {

    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    static boolean[][] visited;
    static int n,shark = 2; //n : �Ѻ��� ����, shark : �Ʊ����� ũ��
    static int minFish = Integer.MAX_VALUE;
    static LinkedList<Point> queue1 = new LinkedList<>();//�ܺ� ť
    static int eat=0,answer=0;//���� ����� ��
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int s_x=-1,s_y=-1;
        for(int i=0;i<n;i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0;j<n;j++) {
                map[i][j]=Integer.parseInt(input[j]);
                if(map[i][j]==9) {
                    s_x=j;s_y=i;
                }
                minFish = Math.min(map[i][j], minFish);
            }

        }

        queue1.offer(new Point(s_x,s_y,0));

        while(true) {
            Point point = queue1.poll();
            map = bfs(point,map);
            if(map==null) break;
            answer=queue1.peek().dis;

//			System.out.println("���ũ�� : "+shark);
//
//			System.out.println("���� �Ÿ� : "+answer );
//			for(int i=0;i<n;i++)
//				System.out.println(Arrays.toString(map[i]));
//			System.out.println("=======================");
        }

        System.out.println(answer);

        br.close();
    }

    public static int[][] bfs(Point input, int[][] arr) {
        LinkedList<Point> queue = new LinkedList<>();//���� ť
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->{
            if(a.dis==b.dis) {
                if(a.y==b.y)
                    return Integer.compare(a.x,b.x);
                return Integer.compare(a.y,b.y);
            }
            return Integer.compare(a.dis, b.dis);
        });
        Point output = null;
        int d=0;
        queue.offer(input);
        arr[input.y][input.x]=0;
        boolean[][] visitedTmp = new boolean[n][n];
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            if(visitedTmp[point.y][point.x]) continue;
            if(arr[point.y][point.x]>shark) continue;
            if(arr[point.y][point.x]>=1 && arr[point.y][point.x]<Math.min(shark, 7)) {
                pq.offer(point);
            }
            visitedTmp[point.y][point.x] = true;
            for(int i=0;i<4;i++) {
                int nx = point.x+dx[i], ny = point.y+dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=n) continue; // ����̰ų� �湮�ߴٸ�
                queue.offer(new Point(nx,ny,point.dis+1));
            }
        }
        output = pq.poll();
        if(output==null) return null;
        arr[output.y][output.x]=9;
        queue1.offer(output);
        eat++;
//		System.out.println("���� ����� �� : "+eat);
        if(eat==shark) {
            shark++;
            eat=0;
        }
        return arr;
    }

}
