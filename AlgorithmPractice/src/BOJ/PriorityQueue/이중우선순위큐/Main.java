package BOJ.PriorityQueue.이중우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t;i++) {
        	int n = Integer.parseInt(br.readLine());
        	TreeMap<Integer,Integer> map = new TreeMap<>();
        	for(int j=0;j<n;j++) {
        		String[] tmp = br.readLine().split(" ");
            	
            	switch(tmp[0]) {
            		case "I"->{
            			int num = Integer.parseInt(tmp[1]);
            			map.put(num, map.getOrDefault(num, 0)+1);
            		}
            		case "D"->{
            			if(!map.isEmpty())
            			switch(tmp[1]) {
            				case "1"->{
            					int key = map.lastKey();
            					map.put(key,map.getOrDefault(key, 0)-1 );
            					if(map.getOrDefault(key,0)==0)
            						map.pollLastEntry();
            				}
            				case "-1"->{
            					int key = map.firstKey();
            					map.put(key,map.getOrDefault(key, 0)-1 );
            					if(map.getOrDefault(key,0)==0)
            						map.pollFirstEntry();
            				}
            			}
            		}
            	}
            	
        	}
        	if(map.isEmpty()) {
        		sb.append("EMPTY").append("\n");
        	}else if(map.size()==1) {
        		int num_tmp = map.firstKey();
        		sb.append(num_tmp+" "+num_tmp).append("\n");
        	}
        	else
        		sb.append(map.pollLastEntry().getKey()+" "+map.pollFirstEntry().getKey()).append("\n");
        	
        }
        System.out.println(sb);
        br.close();
    }
}