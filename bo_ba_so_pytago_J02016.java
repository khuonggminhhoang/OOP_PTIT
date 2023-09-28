import java.util.Arrays;
import java.util.Scanner;

public class bo_ba_so_pytago_J02016 {
    public static boolean check(long[] a, int n){
        for(int i=0; i<n-2; ++i){
            for(int j=i+1; j<n-1; ++j){
                if(Arrays.binarySearch(a, j, n, a[i] + a[j]) > 0){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            long[] a = new long[n];
            for(int i=0; i<n; ++i){
                int x = scn.nextInt();
                a[i] = 1l *x * x;
            }

            Arrays.sort(a);
            System.out.println((check(a, n)) ? "YES" : "NO");
        }
    }
}
