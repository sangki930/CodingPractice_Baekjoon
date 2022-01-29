package BOJ.dp.가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 이분탐색
public class MainAnother {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int arr[]=new int[n];
		int idx=0;
		for(String input:br.readLine().split(" ")) {
			arr[idx++]=Integer.parseInt(input);
		}
		
		ArrayList<Integer> sub = new ArrayList<>();
		sub.add(arr[0]);
		for(int i=1;i<arr.length;i++) {
			int num = arr[i];
			if(num>sub.get(sub.size()-1))
				sub.add(num);
			else
			{
				int j = bs(sub, num);
				sub.set(j,num);
			}
			
		}
		System.out.println(sub.size());
		br.close();
	}
	
	private static int bs(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;
        
        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }
            
            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }

}
