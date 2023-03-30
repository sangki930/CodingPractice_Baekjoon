package BOJ.greedy.¹è;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] crane = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            crane[i] = Integer.parseInt(input[i]);
        }
        int m = Integer.parseInt(br.readLine());
        int[] boxes = new int[m];

        List<Integer> queue = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        queue.sort(Comparator.reverseOrder());
        Arrays.sort(crane);
//		System.out.println(Arrays.toString(boxes));
//		System.out.println(Arrays.toString(crane));
        int answer = 0;
        if(crane[n-1]<queue.get(0)) {
            answer = -1;
        }else {
            int cnt = 0;
            boolean[] completed = new boolean[m];
            while(!queue.isEmpty()) {
                int tmp = cnt;
                for(int j=n-1;j>=0;j--) {
                    for(int i=0;i<queue.size();i++) {
                        if(crane[j]>=queue.get(i)) {
                            queue.remove(i);
                            break;
                        }
                    }
                }

//				System.out.println(Arrays.toString(completed));
                answer++;
            }
//			System.out.println("µµ´Þ?");
        }

        System.out.println(answer);

        br.close();
    }

}

