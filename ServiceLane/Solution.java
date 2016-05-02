import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int T = in.nextInt();
        int [] segments = new int[N];
        for (int i =0;i<N;i++){
            segments[i] = in.nextInt();
        }
        
        for (int i=0; i<T; i++){
            int start = in.nextInt();
            int end = in.nextInt();
            int vehicle = 3; //assume truck can pass
            //System.out.println("start " + start + "end " + end + "segments " + Arrays.toString(segments));
            for (int j=start; j<=end;j++){
                if (segments[j]<3){
                    vehicle = Math.min(vehicle, 2);
                }
                if (segments[j]<2){
                    vehicle = 1;
                }
            }
            System.out.println(vehicle);
        }
    }
}