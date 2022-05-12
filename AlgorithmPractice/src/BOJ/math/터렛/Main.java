package BOJ.math.터렛;

import java.util.Scanner; 
public class Main {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        int T = sc.nextInt(); 
        for(int t=0; t<T; t++){ 
            int x[]=new int[3]; 
            int y[]=new int[3]; 
            int r[]=new int[3]; 
            for(int i=1; i<=2; i++){ 
                x[i] = sc.nextInt(); 
                y[i] = sc.nextInt(); 
                r[i] = sc.nextInt(); 
            } 
            double dotDistance = Math.sqrt(Math.pow(x[1]-x[2],2) + Math.pow(y[1]-y[2],2)); // 두 점사이의 거리 
            int circleSum = r[1]+r[2]; // 두 원의 반지름 합 
            int circleSub = Math.abs(r[1]-r[2]); // 두 원의 반지름 차 
            if (dotDistance==0 && circleSub==0){ // 두 점사이의 거리가 0이고 반지름의 차가 0 -> 같은 원 
                System.out.println(-1); 
            }else if (dotDistance < circleSub || dotDistance > circleSum){ // 두 원이 안만날 때 
                System.out.println(0); 
            } else if(dotDistance == circleSub || dotDistance == circleSum) { // 한 점에서 만날 때 (내접, 외접) 
                System.out.println(1); 
            } 
            else { //dotDistance > circleSub || dotDistance < circleSum 두 점에서 만날 때 
                System.out.println(2); 
            } 
        } 
        sc.close(); 
    }
}
