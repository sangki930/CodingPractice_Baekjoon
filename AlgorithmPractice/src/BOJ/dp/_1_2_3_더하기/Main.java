package BOJ.dp._1_2_3_더하기;

import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        int n;
        
        int[] output = new int[11]; //�������� ������Ű�� �޸� �ʰ��� �Ǽ� �������� ����
        output[1] = 1; // 1�� ���� ��� ����� �� 1����(1)
        output[2] = 2; // 2�� ���� ��� ����� �� 2����(1+1, 2)
        output[3] = 4; // 3�� ���� ��� ����� �� 3���� (1+1+1, 1+2, 2+1, 3)
        
        for(int i=0; i<t; i++){
            n = scanner.nextInt();
            
            for(int j=4; j<=n; j++){
                output[j] = output[j-1] + output[j-2] + output[j-3];
            }
            System.out.println(output[n]);
        }
    }
}
