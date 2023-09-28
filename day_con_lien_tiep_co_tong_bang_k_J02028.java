import java.util.Arrays;
import java.util.Scanner;

public class day_con_lien_tiep_co_tong_bang_k_J02028 {
    public static boolean check(long[] f,int n, long k){
        if(Arrays.binarySearch(f,0,n,k) > 0) return true;
        for(int i=0; i< n-1; ++i){
            long tmp = f[i] + k;
            if(Arrays.binarySearch(f, i + 1, n, tmp) > 0) return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            int n = scn.nextInt();
            long k = scn.nextLong();
            long[] a = new long[n];
            long[] f = new long[n];
            for(int i=0; i<n; ++i){
                a[i] = scn.nextLong();
            }

            f[0] = a[0];
            for(int i=1; i<n; ++i){
                f[i] = f[i-1] + a[i];
            }
            System.out.println((check(f,n,k))? "YES" : "NO");
        }
    }
}
