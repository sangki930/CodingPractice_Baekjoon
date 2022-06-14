package BOJ.stack.Á¦·Î;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()),sum=0;
        Stack<Integer> stack = new Stack<>();
        while(n-->0){
            int tmp=Integer.parseInt(br.readLine());
            if(tmp==0)
            {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.add(tmp);
        }
        while(!stack.isEmpty())
            sum+=stack.pop();
        System.out.println(sum);
    }
}