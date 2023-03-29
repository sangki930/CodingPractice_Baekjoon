package BOJ.dp.가장긴증가하는부분수열04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // �̺�Ž���� ���� �����ϴ� ������ ������ ��ü
        List<Integer> list = new ArrayList<>();
        // �Էµ� ������ ����
        int arr[] = new int[n + 1];
        // �Էµ� �� ������ ��ġ�� ����
        int indexArr[] = new int[n + 1];

        // ������ �Է¹޾� �����Ѵ�.
        for(int i = 1 ; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        list.add(Integer.MIN_VALUE);

        for(int i = 1 ; i <= n; i++){
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;

            // Ȯ���ϴ� ���ڰ� ������ ������ ������ ū ���
            // ������ �߰����ش�.
            if(num > list.get(list.size() - 1)) {
                list.add(num);
                indexArr[i] = list.size() - 1;
            }
            // Ȯ���ϴ� ���ڰ� ������ ������ ������ ���� ���
            else{
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }
                list.set(right, num);
                indexArr[i] = right;
            }
        }
        // ���� ���� ���
        sb.append(list.size() - 1 + "\n");
        // ������ ��θ� ������ stack
        Stack<Integer> stack = new Stack<>();

        // ���� ã�� ���ϴ� ���������� �ε��� ��
        int index = list.size() - 1;

        for(int i = n; i > 0; i--){
            // ã�� ���ϴ� �ε����� ���� ���
            if(indexArr[i] == index){
                // ã�� ���ϴ� �ε����� �ϳ� ���ҽ�Ų��.
                // ���� �ε����� ���� ã�� ���ؼ�
                index--;
                // stack�� ��θ� �߰��Ѵ�.
                stack.push(arr[i]);
            }
        }

        // ���ÿ��� ������ ã�´�.
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}