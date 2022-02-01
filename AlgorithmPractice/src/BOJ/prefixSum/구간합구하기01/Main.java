package BOJ.prefixSum.구간합구하기01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n,m,k;
	static long[] arr;
	static long[] tree;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]); 
		k = Integer.parseInt(input[2]);
		
		int height = (int)Math.ceil(Math.log(n)/Math.log(2));

		tree = new long[(int)Math.pow(2, height+1)];
		arr =new long[1000001];
		for(int i=0;i<n;i++) {
			input = br.readLine().split(" ");
			arr[i]=Long.parseLong(input[0]);
		}
		init(1,0,n-1);
		for(int i=0;i<m+k;i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			long b = Integer.parseInt(input[1]);
			long c= Long.parseLong(input[2]);
			if(a==1) {
				long diff = c-arr[(int) (b-1)];
	            arr[(int) (b-1)]=c;
	            update(1,0,n-1,b-1,diff);
			}else if(a==2)
				System.out.println(sum(1,0,n-1,b-1,c-1));
		}
		
		br.close();

	}
	
	static long init(int node, long start, long end) {
		if(start==end) return tree[node] = arr[(int) start];
		long mid = (start+end)/2;
		return tree[node] = init(2*node,start,mid)+init(2*node+1,mid+1,end);
	}
	
	static long sum(int node, long start, long end, long left, long right){
	    if(left>end || right<start) return 0;
	    if(left<=start && end<=right) return tree[node];
	    long mid = (start+end)/2;
	    return sum(node*2,start,mid,left,right) + sum(node*2+1,mid+1,end,left,right);
	}

	static void update(int node, long start, long end, long idx, long diff){
	    if(idx<start || idx>end) return;
	    tree[node]+=diff;
	    if(start==end) return;
	    long mid = (start+end)/2;
	    update(node*2,start,mid,idx,diff);
	    update(node*2+1,mid+1,end,idx,diff);
	}

}
