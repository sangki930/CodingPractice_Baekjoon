package BOJ.dp.육각수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(solution(n));
		
		br.close();
	}
	
	public static int solution(int n) {

		List<Integer> list = new ArrayList<>();
		
		for(int i=1;;i++) {
			int sum = i*(2*i-1);
			if(sum>1000000) break;
			list.add(sum);
		}
		list.sort(Comparator.reverseOrder());
		int answer = 1000000;
		int[] d = new int[13];
		
		Arrays.fill(d,Integer.MAX_VALUE);
		d[0]=0;
		for(int k=1;k<=12;k++)
			for(int i=0;i<list.size();i++) {
				int v = list.get(i);
				int t = k;
				int j = i;
				int cnt = 0;
				while(t>0) {
					if(t<list.get(j)) {
						j++;
					}else {
						t-=list.get(j);
						cnt++;
					}
				}
				
				d[k] = Math.min(d[k], cnt);
			}
		
		if(n<13) {
			answer = d[n];
		}else {
			int[] dp = new int[n + 1];
			for (int i = 0; i < d.length; i++) {
                dp[i] = d[i];
            }
			list.sort((a,b)->a-b);
            for (int i = 13; i < n + 1; i++) {
                int min = Integer.MAX_VALUE;
                for (int a : list) {
                	
                    if (a > i) {
                        break;
                    }
                    min = Math.min(min, dp[i - a]);
                }
                dp[i] = min + 1;
                
            }
            answer = dp[n];
		}
		
		return answer;
	}

}
