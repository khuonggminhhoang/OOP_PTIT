import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class xep_hang_J02009 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Integer[][] a = new Integer[n][2];
        for(int i=0; i<n; ++i){
            a[i][0] = scn.nextInt();
            a[i][1] = scn.nextInt();
        }

        Arrays.sort(a, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });

        int t = a[0][0]  + a[0][1];
        for(int i=1; i<n; ++i){
            if(a[i][0] < t){
                t += a[i][1];
            }
            else{
                t = a[i][0] + a[i][1];
            }
        }
        System.out.println(t);
    }    
}
