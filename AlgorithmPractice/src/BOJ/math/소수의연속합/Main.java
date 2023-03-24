package BOJ.math.소수의연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static boolean prime[] = new boolean[4000001];
    static List<Integer> prime_list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        prime();
        int size = prime_list.size();

        int count = 0;
        int left = 0;
        int right = 0;

        while (true) {
            int sum = sum(left, right);
            if (sum == N) {
                count ++;
                right ++;
            } else if (sum < N) {
                right ++;
            } else {
                left ++;
            }
            if (right == size || left == size || left > right) {
                break;
            }
        }

        System.out.println(count);
    }

    static void prime() {

        int n = 4000000;
        // �냼�닔媛� �븘�땲硫� true
        prime[0] = prime[1] = true;

        for (int i = 2; i*i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i < 4000001; i++) {
            if (!prime[i]) {
                prime_list.add(i);
            }
        }
    }

    static int sum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += prime_list.get(i);
        }
        return sum;
    }
}