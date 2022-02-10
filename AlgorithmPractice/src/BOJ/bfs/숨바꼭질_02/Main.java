package BOJ.bfs.¼û¹Ù²ÀÁú_02;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    static int N;
    static int K;
    static int[] check = new int[100001];
    static int answer=0;
    static Map<Long,Long> map = new TreeMap<>((a,b)->Long.compare(a, b));
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0+"\n"+1);
            return ;
        }
        else {
            bfs(N);
        }
        Long key = !map.keySet().isEmpty()?map.keySet().iterator().next():0L;
        System.out.print(key+"\n"+map.getOrDefault(key,(long) 1));
    }

    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        check[num] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    map.put((long)check[temp], map.getOrDefault((long)check[temp], 0L)+1L);
                    continue;
                }

                if (next >= 0 && next < check.length) {
                		
                	if(check[next]==0) {
                        check[next] = check[temp] + 1;
                        q.add(next);
                	}else if(check[next]>0 && map.containsKey((long)check[next])) {
                		map.put((long)check[temp], map.getOrDefault((long)check[temp], 0L)+1L);
//                		q.add(next);
                	} 
                }
            }
        }
    }
}
