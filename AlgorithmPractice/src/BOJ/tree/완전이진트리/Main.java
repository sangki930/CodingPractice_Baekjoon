package BOJ.tree.완전이진트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
	
	int id;
	int no;
	int level;
	Node left;
	Node right;
	/**
	 * @param id
	 * @param no
	 * @param level
	 * @param left
	 * @param right
	 */
	public Node(int id, int no, int level, Node left, Node right) {
		this.id = id;
		this.no = no;
		this.level = level;
		this.left = left;
		this.right = right;
	}
	
}

public class Main {

	static Node[] nodes;
	static int k,num_node;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		num_node = (int)Math.pow(2, k)-1;
		nodes = new Node[num_node];
		
		
		br.close();
	}
	
	public static Node makeTree(int id,int level) {
		if(level==k) return null;
		if(nodes[id]==null) nodes[id] = new Node(id+1,-1,(int)(Math.log(id+1)/Math.log(2))+1,null,null);
		nodes[id].left = makeTree(id*2,level+1);
		nodes[id].right = makeTree(id*2+1,level+1);
		return nodes[id];
	}

}
