package BOJ.문자열.컬러볼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Pair{
	int c;
	int s;
	int id;
	long sum;
	public Pair(int c, int s,int id) {
		super();
		this.c = c;
		this.s = s;
		this.id=id;
	}
	@Override
	public String toString() {
		return "Pair [c=" + c + ", s=" + s + ", id=" + id + ", sum=" + sum + "]";
	}
	
	
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Pair[] pairs = new Pair[n];
		long[] save = new long[200001];
		long[] ss = new long[2001];
		for(int i=0;i<n;i++) {
			String[] input = br.readLine().split(" ");
			int c = Integer.parseInt(input[0]), s = Integer.parseInt(input[1]);
			pairs[i]=new Pair(c,s,i);
		}
		long[] result = new long[n];
		Arrays.sort(pairs, (a,b)->{
			if(a.s==b.s)
				return Integer.compare(a.c, b.c);
			return Integer.compare(a.s, b.s);
		});
		System.out.println(Arrays.toString(pairs));
		result[0]=0;
		save[pairs[0].c]+=pairs[0].s;
		pairs[0].sum=pairs[0].s;
		ss[pairs[0].s]++;
		
		for(int i=1;i<pairs.length;i++) {
			
			result[pairs[i].id] = pairs[i-1].sum-save[pairs[i].c]-ss[pairs[i].s]*pairs[i].s;
			if(pairs[i].c==pairs[i-1].c && pairs[i].s==pairs[i-1].s) {
				System.out.println("반응");
				result[pairs[i].id]+=pairs[i].s;
			}
				
			save[pairs[i].c]+=pairs[i].s;
			ss[pairs[i].s]++;
			pairs[i].sum=pairs[i-1].sum+pairs[i].s;
			System.out.println(Arrays.toString(pairs));
		}

		for(long r : result)
			System.out.println(r);
		
		br.close();
	}

}
