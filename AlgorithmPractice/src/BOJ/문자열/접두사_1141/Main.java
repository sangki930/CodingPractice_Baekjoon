package BOJ.문자열.접두사_1141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] arr= new String[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=br.readLine();
		}
		
		Arrays.sort(arr, (a,b)->{
			return Integer.compare(a.length(), b.length());
		});
		
		int answer=0;
		
		for(int i=0;i<n;i++) {
			String now = arr[i];
			boolean isHead=false;
			for(int j=i+1;j<n;j++) {
				if(arr[j].indexOf(now)==0)
				{
					isHead=true;
					break;
				}
			}
			if(!isHead)
				answer++;
		}
		System.out.println(answer);
		
		br.close();
	}

}
