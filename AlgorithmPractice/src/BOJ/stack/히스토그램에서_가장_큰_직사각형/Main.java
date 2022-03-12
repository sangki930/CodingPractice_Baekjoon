package BOJ.stack.������׷�����_����_ū_���簢��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
// ���ͳ� �˻� ����
public class Main {
	
	public static int[] histogram;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int N;
		while(true) {
 
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0) {
				break;
			}
			histogram = new int[N];
			for(int i = 0; i < N; i++) {
				histogram[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(getArea(N)).append('\n');
			histogram = null;
			
		}
		System.out.println(sb);
	}
	
	public static long getArea(int len) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		long maxArea = 0;
		
		for(int i = 0; i < len; i++) {
			
			/*
			 *  ���� ü���� ���̺��� ���� ������׷� ���̰� �۰ų� �������
			 *  i��° ���뺸�� ���� ���� ü�ε��� pop�ϸ鼭 �ִ� ���̸� �����ش�.
			 *  
			 */
			while((!stack.isEmpty()) && histogram[stack.peek()] >= histogram[i]) {
				int height = histogram[stack.pop()];	// ���� ü���� ����
				
				/*
				 * pop�� �� �� ������ ����ü���� ���� ���ٸ� 0��° index ���� (i-1)��° �ε���������
				 * ������ ���� �ȴ�. (���� i�� ��)
				 * �ݸ� ������ ������� �ʴٸ� �̴� pop�� ���̺��� �� ���� ���̸� ����
				 * ü���� ����ִٴ� ���̹Ƿ� (i-1)��° index���� �� ���� ���� ü���� index�� 
				 * ���� ���� ���� �ȴ�.
				 */
				long width = stack.isEmpty() ? i : i - 1 - stack.peek(); 
				System.out.println("���� ���� : "+height*width);
				maxArea = Math.max(maxArea, height * width);	// �ִ� ���� �� ����
			}
			
			/*
			 *  �� ������ ������ ���ÿ� ����Ǿ��ִ� ü���� ��� i���� �۰ų� ����
			 *  ü�ε� ���̹Ƿ� i��° index�� �־��ش�.
			 */
			stack.push(i);
			
		}
		System.out.println(stack+", len : "+len);
		// �� ������ ������ Stack�� �����ִ� ü�ε��� ������ �� �����Ƿ� �������� ���Ͱ��� ������ ��ģ��.
        while(!stack.isEmpty()) {
            int height = histogram[stack.pop()];
            
            /*
             * ���� pop�ϰ� �� �� ������ ����ִٸ� �̴� �����ִ� ü���� ���ٴ� ���̰�
             * ��� 0 ~ (len - 1) ������ ��ü ���� width�� �Ǵ� ���̴�. 
             */
//            System.out.println("peek : "+stack.peek());
            long width = stack.isEmpty() ? len: len - 1 - stack.peek();
            System.out.println("width : "+width);
            System.out.println("��ó�� ���� ���� : "+height*width);
            maxArea = Math.max(maxArea, width * height);
        }
		
        return maxArea;
		
	}
	
 
}
