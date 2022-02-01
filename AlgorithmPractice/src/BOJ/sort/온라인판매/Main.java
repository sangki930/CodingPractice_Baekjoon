package BOJ.sort.온라인판매;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
			
			String input[]=br.readLine().split(" ");
			
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int arr[]=new int[m];
			for(int i=0;i<m;i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(arr);
			int max = 1;
			int price = 1;
			
			for(int i=0;i<arr.length;i++) {
				int answer;
				if(n>=m)
				answer=arr[i]*(m-i);
				else
				answer=arr[i]*Math.min(m-i,n);
				if(answer>=max) {
					price = arr[i];
					max = answer;
				}
			}
			System.out.println(price+" "+max);
			
			
			br.close();
	}

}
