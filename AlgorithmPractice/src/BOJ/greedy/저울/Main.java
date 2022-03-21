package BOJ.greedy.Àú¿ï;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] input = br.readLine().split(" ");
		for(int i=0;i<n;i++)
	        arr[i]=Integer.parseInt(input[i]);
	    
	    Arrays.sort(arr);
	    int nxt=1;
	        
	    for(int w:arr){
	        if(w>nxt)
	            break;
	        nxt+=w;
	    }
	        
	     System.out.println(nxt);
		
		br.close();
	}

}
