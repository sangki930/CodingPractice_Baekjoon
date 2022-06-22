package BOJ.PriorityQueue.Àý´ñ°ªÈü;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;


public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int n = Integer.valueOf(br.readLine());
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->{
        	if(Math.abs(a)==Math.abs(b))
        		return Integer.compare(a, b);
        	else
        		return Integer.compare(Math.abs(a), Math.abs(b));
        });
        
        for(int i=0;i<n;i++) {
        	int c = Integer.valueOf(br.readLine());
        	if(c!=0) {
        		pq.offer(c);
        	}else {
        		if(pq.isEmpty())
        			bw.write(0+"\n");
        		else
        			bw.write(pq.poll()+"\n");
        	}
        }
		
		bw.flush();
		bw.close();
		br.close();
	}
 

}
