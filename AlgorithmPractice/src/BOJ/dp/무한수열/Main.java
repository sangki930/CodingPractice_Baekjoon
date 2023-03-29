package BOJ.dp.무한수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
 
public class Main {
 
	static long n,p,q;
	static Map<Long,Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Long.parseLong(input[0]);
        p = Long.parseLong(input[1]);
        q = Long.parseLong(input[2]);
        map.put(0L, 1L);
        System.out.println(func(n));
        
        br.close();
    }
    
    public static Long func(long a) {
    	
    	if(a==0) return 1L;
    	if(map.containsKey(a)) {
    		return map.getOrDefault(a,(long) 0);
    	}
    	
    	Long ret = func(a/p)+func(a/q);
    	map.put(a, ret);
    	return ret;
    }
}
