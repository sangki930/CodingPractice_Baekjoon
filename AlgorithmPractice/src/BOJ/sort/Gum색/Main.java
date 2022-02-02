package BOJ.sort.Gum»ö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Data{
	int id;
	int rank;
	public Data(int id, int rank) {
		this.id = id;
		this.rank = rank;
	}
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
        int[] ranks = new int[n];
        input = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
        	ranks[i]=Integer.parseInt(input[i]);
        }
        Map<Integer,ArrayList<Data>> map = new HashMap<>();
        for(int i=1;i<=n;i++) {
        	input = br.readLine().split(" ");
        	int m2 = Integer.parseInt(input[0]);
        	for(int j=1;j<=m2;j++) {
        		int k = Integer.parseInt(input[j]);
        		ArrayList<Data> list = map.getOrDefault(k,new ArrayList<>());
        		list.add(new Data(i,ranks[i-1]));
        		map.put(k, list);
        	}
        	
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++) {
        	int k = Integer.parseInt(br.readLine());
        	ArrayList<Data> list = map.getOrDefault(k,new ArrayList<>());
        	if(list.isEmpty()) {
        		sb.append("-1").append("\n");
        		continue;
        	}
        	list.sort((a,b)->{
        		if(a.rank==b.rank)
        			return Integer.compare(a.id, b.id);
        		return Integer.compare(a.rank, b.rank);
        	});
        	
        	for(Data data : list) {
        		sb.append(data.id).append(" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb.toString().trim());
        br.close();
    }
}
