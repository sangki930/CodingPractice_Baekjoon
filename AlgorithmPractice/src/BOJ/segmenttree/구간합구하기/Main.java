package BOJ.segmenttree.구간합구하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	// 구간 합 구하기
		
		private static long query(long[] tree, int node, int start, int end, int left, int right) {
	        if (left > end || right < start) {
	            return 0;
	        }
	        if (left <= start && end <= right) {
	            return tree[node];
	        }
	        long lsum = query(tree, node*2, start, (start+end)/2, left, right);
	        long rsum = query(tree, node*2+1, (start+end)/2+1, end, left, right);
	        return lsum+rsum;
	    }

		// 값 변경
		private static void update(long[] arr, long[] tree, int node, int start, int end, int index, long val) {
			// TODO Auto-generated method stub
			if(index<start || index>end)
				return;
			if(start==end) { // 리프노드이면
				tree[node] = val;
				arr[index] = val;
				return ;
			}
			
			update(arr, tree,node*2, start, (start+end)/2, index, val);
	        update(arr, tree,node*2+1, (start+end)/2+1, end, index, val);
	        tree[node] = tree[node*2] + tree[node*2+1];
		}

		// init : 세그먼트 트리생성
		// a: 배열 A
		// tree: 세그먼트 트리
		// node: 노드 번호
		// node에 저장되어 있는 합의 범위가 start - end
		static void init(long[] a, long[] tree, int node, int start, int end) {
	        if (start == end) {
	            tree[node] = a[start];
	        } else {
	            init(a, tree, node*2, start, (start+end)/2);
	            init(a, tree, node*2+1, (start+end)/2+1, end);
	            tree[node] = tree[node*2] + tree[node*2+1];
	        }
	    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), k = Integer.parseInt(input[2]);
        m+=k;
        long[] arr = new long[n];
        for(int i=0;i<n;i++) {
        	arr[i] = Long.parseLong(br.readLine());
        }
        int h = (int)Math.ceil(Math.log(n) / Math.log(2));
        int tree_size = (1 << (h+1));
        long[] tree = new long[tree_size];
        
        init(arr,tree,1,0,n-1);
        
        while(m-->0) {
        	input = br.readLine().split(" ");
        	int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]); 
        	
        	if(a==1) {
        		long c = Long.parseLong(input[2]);
        		update(arr,tree,1,0,n-1,b-1,c);
        	}else {
        		int c = Integer.parseInt(input[2]);
        		bw.write(query(tree, 1, 0, n-1, b-1, c-1)+"\n");
        	}
        	
        }
        
        bw.flush();
        br.close();
        bw.close();
	}

	
}
