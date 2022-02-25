package BOJ.dp.Á¤¼ö»ï°¢Çü;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void bi_search(int arr[],int target){
            int n=arr.length;
            int start=0;
            int end=n-1;
            int mid=(start+end)/2;
            
            while(end>=start){
                mid=(start+end)/2;
                if(arr[mid]==target){
                    System.out.println(1);
                    return;
                }else if(arr[mid]>target)
                    end=mid-1;
                else
                    start=mid+1;
            }
            
            System.out.println(0);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        int arr[]=new int[a];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<a;i++)
            arr[i]=Integer.parseInt(input[i]);
        Arrays.sort(arr);
        int b=Integer.parseInt(br.readLine());
        
        input = br.readLine().split(" ");
        for(int i=0;i<b;i++){
            bi_search(arr,Integer.parseInt(input[i])); 
        }
       
        br.close();
    }
}
