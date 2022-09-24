package BOJ.greedy.sort.¼ÒÆ®;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[] arr;
	static int s,j;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		String[] input = br.readLine().split(" ");
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(input[i]);
		s = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n && s>0;i++) {
			int max=arr[i], maxi=i;
			for(j=i+1;j<n && j<=i+s;j++)
				if(max<arr[j]) {
					max=arr[j];
					maxi=j;
				}
			s-=maxi-i;
			while(maxi>i) {
				arr[maxi]=arr[maxi-1];
				maxi--;
			}
			arr[i]=max;
					
		}
		for(int i : arr)
			System.out.print(i+" ");
		
		br.close();
	}

}
