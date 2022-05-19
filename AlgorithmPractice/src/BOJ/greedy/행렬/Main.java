package BOJ.greedy.За·Д;

import java.util.Scanner;

public class Main{
static int N, M;
static char a[][]=new char[50][50], b[][]=new char[50][];
static int result;
 
static void change(int x, int y)
{
    for (int i = x; i < x + 3; i++)
    {
        for (int j = y; j < y + 3; j++)
        {
            if (a[i][j] == '1') a[i][j] = '0';
            else a[i][j] = '1';
        }
    }
}
 
public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in); 
    N=sc.nextInt();
    M=sc.nextInt();
    sc.nextLine();
 
    for (int i = 0; i < N; i++)
        a[i]=sc.nextLine().toCharArray();
    
    for (int i = 0; i < N; i++)
       b[i]=sc.nextLine().toCharArray();
 
    for (int i = 0; i < N - 2; i++)
    {
        for (int j = 0; j < M - 2; j++)
        {
            if (a[i][j] != b[i][j])
            {
                change(i, j);
                result++;
            }
        }
    }
 
    boolean isDifferent = false;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (a[i][j] != b[i][j])
            {
                isDifferent = true;
            }
        }
    }
 
    if (isDifferent) 
        System.out.println(-1);
    else
        System.out.println(result);
}
}