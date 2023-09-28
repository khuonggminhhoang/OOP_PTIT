import java.util.Scanner;

public class J01025 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int minx = Integer.MAX_VALUE, maxx = Integer.MIN_VALUE;
        int miny = Integer.MAX_VALUE, maxy = Integer.MIN_VALUE;
        for(int i=0; i<4; ++i){
            int x = scn.nextInt(), y = scn.nextInt();
            minx = Math.min(minx, x);
            maxx = Math.max(maxx, x);
            miny = Math.min(miny, y);
            maxy = Math.max(maxy, y);
        }
        int edge = Math.max((maxx - minx), (maxy - miny));
        System.out.println(edge * edge);
    }
}