package BOJ.implementation.소용돌이_예쁘게_출력하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Point{
	int x,y,v;
	public Point(int x, int y, int v) {
		this.x=x;
		this.y=y;
		this.v=v;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", v=" + v + "]";
	}

}

public class Main{
	
	static int r1,c1,r2,c2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		// 순서대로 r1,c1,r2,c2
		r1=arr[0];
		c1=arr[1];
		r2=arr[2];
		c2=arr[3];
		int x = 0, y = 0;
		int num=1;
		int level = 1;
		List<Point> list = new ArrayList<>();
		if(isInSelectedArea(0, 0))
			list.add(new Point(0,0,1));
		while(isInBoard(x,y)) {
			
			for(int i=0;i<level-1;i++) {
				num++;y--;
				if(isInSelectedArea(x, y))
					list.add(new Point(x,y,num));
				
			}
			
			for(int i=0;i<level-1;i++) {
				num++;x--;
				if(isInSelectedArea(x, y))
					list.add(new Point(x,y,num));
				
			}
			
			for(int i=0;i<level-1;i++) {
				num++;y++;
				if(isInSelectedArea(x, y))
					list.add(new Point(x,y,num));
				
			}
			
			for(int i=0;i<level-1;i++) {
				num++;x++;
				if(isInSelectedArea(x, y))
					list.add(new Point(x,y,num));
				
			}
			if(level*level==num) {
				level+=2;
				x++;y++;
				continue;
			}
		}
		int max_len = (list.stream().map(i->i.v).max((o1, o2) -> Integer.compare(o1, o2)).get()+"").length();
		list.sort((o1,o2)->{
			if(o1.y==o2.y) return Integer.compare(o1.x, o2.x);
			return Integer.compare(o1.y, o2.y);
		});

		int idx = 0;
		StringBuilder answer = new StringBuilder();
		for(int i=r1;i<=r2;i++) {
			for(int j=c1;j<=c2;j++) {
				Point point = list.get(idx++);
				answer.append(String.format("%"+max_len+"d", point.v)).append(" ");
			}
			answer.append("\n");
		}
		System.out.println(answer);
		br.close();
	}
	
	public static boolean isInBoard(int x, int y) {
		return (-5000 <= x && x <= 5000) && (-5000 <= y && y <=5000);
	}
	
	public static boolean isInSelectedArea(int x, int y) {
		return (c1 <= x && x <= c2) && (r1 <= y && y <=r2);
	}
}
