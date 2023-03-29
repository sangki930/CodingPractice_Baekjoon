package BOJ.bruteforce.셀프_넘버;

import java.util.*;

public class Main{
    public static void main(String[] args){
     
       List<Integer> list = new ArrayList<>();
        int index = 1;
       while(index<=10000){
           
           if(!list.contains(index)){
               System.out.println(index);
           }
           
           list.add(index);
           list.add(d(index));
           index++;   
       }
        
    }
    
    public static int d(int i){
       int sum=i;
        while(i!=0){
            sum += i%10;
            i /= 10;
        }
        return sum;
    }
}
