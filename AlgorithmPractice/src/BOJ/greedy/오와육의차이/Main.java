package BOJ.greedy.������������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		System.out.println(
				(Integer.parseInt(input[0].replaceAll("6","5"))+Integer.parseInt(input[1].replaceAll("6","5")))
				+" "+
				(Integer.parseInt(input[0].replaceAll("5","6"))+Integer.parseInt(input[1].replaceAll("5","6"))));
		br.close();
	}

}
