package BOJ.tree.trie.��ȭ��ȣ���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Data{
	int level;
	char c;
	public Data(int level, char c) {
		super();
		this.level = level;
		this.c = c;
	}
	@Override
	public String toString() {
		return "Data [level=" + level + ", c=" + c + "]";
	}
}

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			int t = Integer.parseInt(br.readLine());
			Map<String,LinkedList<String>> tree = new HashMap<>();
			tree.put("0,0", new LinkedList<>());
			for(int j=1;j<=t;j++) {
				LinkedList<String> nodes = (j!=1)?tree.getOrDefault(j, new LinkedList<>()):tree.getOrDefault(tree, new LinkedList<>());
				
			}
		}
		br.close();
	}

}
