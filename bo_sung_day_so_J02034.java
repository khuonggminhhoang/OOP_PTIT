import java.util.Scanner;

public class bo_sung_day_so_J02034 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] tmp = new int[201];
        int max = 0;

        for(int i=0; i<n; ++i){
            int x = scn.nextInt();
            tmp[x] = 1;
            max = Math.max(max, x);
        }
        int ok = 0;
        for(int i=1; i <= max; ++i){
            if(tmp[i] == 0) {
                System.out.println(i);
                ok=1;
            }
        }
        if(ok == 0) System.out.println("Excellent!");
    }
}
