package BOJ.기하학.어린왕자;

import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int t = Integer.parseInt(line);
        int x1, y1, x2, y2;
        double dA, dB;
        int count = 0;
        for(int i = 0; i < t; i++){
            count = 0;
            line = br.readLine();
            x1 = Integer.parseInt(line.split(" ")[0]);
            y1 = Integer.parseInt(line.split(" ")[1]);
            x2 = Integer.parseInt(line.split(" ")[2]);
            y2 = Integer.parseInt(line.split(" ")[3]);
            line = br.readLine();
            int n = Integer.parseInt(line);
            for(int j = 0; j < n; j++){
                line = br.readLine();
                int cx = Integer.parseInt(line.split(" ")[0]);
                int cy = Integer.parseInt(line.split(" ")[1]);
                int r = Integer.parseInt(line.split(" ")[2]);
                dA = Math.sqrt(Math.pow((double)x1 - (double)cx, 2) + Math.pow((double)y1 - (double)cy, 2));
                dB = Math.sqrt(Math.pow((double)x2 - (double)cx, 2) + Math.pow((double)y2 - (double)cy, 2));
                if(dA < (double)r && dB < (double)r){

                }else if(dA < r){
                    count++;
                }else if(dB < r){
                    count++;
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
