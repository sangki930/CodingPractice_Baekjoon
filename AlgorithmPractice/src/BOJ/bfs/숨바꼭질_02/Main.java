package BOJ.bfs.숨바꼭질_02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] check = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(bfs(N,K));
    }

    static String bfs(int num, int K) {
    	
    	if(num>=K) {
    		return (num-K)+"\n"+1;
    	}
    	
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        check[num] = 1;
        int minTime = Integer.MAX_VALUE,cnt=0;
        
        while (!q.isEmpty()) {
            int now = q.poll();

            if(minTime<check[now]) break;
            
            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = now + 1;
                } else if (i == 1) {
                    next = now - 1;
                } else {
                    next = now * 2;
                }
                
                if(next >= 0 && next < check.length) {
                    if (next == K) {
//                      System.out.println(check[now]);
                    	minTime = check[now];
                      cnt++;
                  }

                  if (check[next] == 0 || check[next]==check[now]+1) {
                      q.add(next);
                      check[next] = check[now] + 1;
                  }
                }
            }
        }
        
        return minTime+"\n"+cnt;
    }
}
