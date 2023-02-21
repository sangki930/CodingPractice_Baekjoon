package BOJ.greedy.���簢����ĥ�ϱ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int K, N;
    static int[] result;
    static ArrayList<ArrayList<Box>> boxes = new ArrayList<>();
    static ArrayList<Size> box_sizes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        result = new int[N];
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            Box new_box = new Box(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            boxes = checkBox(boxes, new_box);
        }

        int l = boxes.size();
        for (int i=0; i<l; i++) {
            box_sizes.add(new Size(calSize(boxes.get(i)), i));
        }

        Collections.sort(box_sizes, new SizeComparator());
        
        for (int i=0; i<N; i++) {
            result[i] = box_sizes.get(i).idx;
        }

        Arrays.sort(result);
        for (int i=0; i<N; i++) {
            System.out.print(result[i] + 1);
            System.out.print(' ');
        }
    }

    static int calSize(ArrayList<Box> cur_box) {
        int sum = 0;
        int l = cur_box.size();
        for (int i=0; i<l; i++) {
            Box box = cur_box.get(i);
            sum += (box.x2 - box.x1) * (box.y2 - box.y1);
        }
        return sum;
    }

    static ArrayList<ArrayList<Box>> checkBox(ArrayList<ArrayList<Box>> cur_boxes, Box new_box) {
        // �տ� ��ȣ ���簢�� �������� �κ� �����
        int l = cur_boxes.size();
        for (int i=0; i<l; i++) {
            ArrayList<Box> small_box = new ArrayList<>();
            int l_b = cur_boxes.get(i).size();
            for (int j=0; j<l_b; j++) {
                Box cur_box = cur_boxes.get(i).get(j);
                // ��� ������ ��, �� ������ ��, �Ϻ� ������ ��
                if (new_box.x1 <= cur_box.x1 && new_box.y1 <= cur_box.y1 && cur_box.x2 <= new_box.x2 && cur_box.y2 <= new_box.y2) {
                    continue;
                } else if (cur_box.x2 <= new_box.x1 || new_box.x2 <= cur_box.x1 || cur_box.y2 <= new_box.y1 || new_box.y2 <= cur_box.y1) {
                    small_box.add(cur_box);
                } else {
                    // ��ġ�� �κ� �����ϰ� �ٽ� �簢�� ���·� �迭�� �־���
                    int cur_x1 = Math.max(cur_box.x1, new_box.x1);
                    int cur_x2 = Math.min(cur_box.x2, new_box.x2);
                    int cur_y1 = Math.max(cur_box.y1, new_box.y1);
                    int cur_y2 = Math.min(cur_box.y2, new_box.y2);
                    if (cur_box.y1 < cur_y1)
                    small_box.add(new Box(cur_box.x1, cur_box.y1, cur_box.x2, cur_y1));
                    if (cur_y2 < cur_box.y2)
                    small_box.add(new Box(cur_box.x1, cur_y2, cur_box.x2, cur_box.y2));
                    if (cur_box.x1 < cur_x1 && cur_y1 < cur_y2)
                    small_box.add(new Box(cur_box.x1, cur_y1, cur_x1, cur_y2));
                    if (cur_x2 < cur_box.x2 && cur_y1 < cur_y2)
                    small_box.add(new Box(cur_x2, cur_y1, cur_box.x2, cur_y2));
                }
            }
            cur_boxes.set(i, small_box);
        }
        ArrayList<Box> cur_box = new ArrayList<>();
        cur_box.add(new_box);
        cur_boxes.add(cur_box);
        return cur_boxes;
    }

    static class Box {

        int x1, x2, y1, y2;

        Box(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static class Size {

        int size, idx;

        Size(int size, int idx) {
            this.size = size;
            this.idx = idx;
        }
    }

    static class SizeComparator implements Comparator<Size> {
        @Override
        public int compare(Size s1, Size s2) {
            if (s1.size > s2.size) {
                return -1;
            } else if (s1.size < s2.size) {
                return 1;
            } else {
                if (s1.idx < s2.idx) {
                    return -1;
                } else if (s1.idx > s2.idx) {
                    return 1;
                }
            } return 0;
        }
    }
}