import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine().trim();

        int answer = Integer.MAX_VALUE;

        while (M > 0) {
            int totalChanges = 0;

            for (int i = 0; i < M; i++) {
                int[] counts = new int[4]; // [A, C, G, T]

                for (int j = i; j < s.length(); j += M) {
                    char c = s.charAt(j);
                    switch (c) {
                        case 'A': counts[0]++; break;
                        case 'C': counts[1]++; break;
                        case 'G': counts[2]++; break;
                        case 'T': counts[3]++; break;
                    }
                }

                int sum = 0;
                int max = 0;
                for (int count : counts) {
                    sum += count;
                    max = Math.max(max, count);
                }
                totalChanges += sum - max;
            }

            answer = Math.min(answer, totalChanges);
            M--;
        }

        System.out.println(answer);
    }
}
