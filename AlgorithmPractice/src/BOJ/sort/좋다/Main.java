package BOJ.sort.좋다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] nums = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.sorted()
					.toArray();
		
		int answer = 0; // 좋은 숫자 개수
		for(int i=0;i<nums.length;i++) {
			int left = 0;
			int right = nums.length-1;
			int target = nums[i];
			int sum = 0;
			
			while(left<right) {
				sum = nums[left]+nums[right];
				if(sum==target) {
					if(i==left) {
						left++;
					}else if(i==right) {
						right--;
					}else {
						answer++;
						break;
					}
				}
				
				if(nums[left]+nums[right]>target) {
					right--;
				}else if(nums[left]+nums[right]<target) {
					left++;
				}
			}
			
		}
		
		System.out.println(answer);
		
		br.close();
	}

}
