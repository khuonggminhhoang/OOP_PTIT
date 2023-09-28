import java.util.Arrays;
import java.util.Scanner;

public class cap_so_co_tong_bang_k_J08015 {
    public static int fisrt(int[] a, int j,int n, int x){
        int ans = -1;
        int l = j + 1, r = n-1;
        while(l <= r){
            int m = (l + r)/2;
            if(a[m] == x){
                r = m - 1;
                ans = m;
            }
            else if(a[m] >x){
                r = m - 1;
            }
            else{
                l= m + 1;
            }
        }
        return ans;
    }

    public static int last(int a[], int j, int n, int x){
        int ans = -1;
        int l = j + 1, r = n -1 ;
        while(l <= r){
            int m = (l + r)/2;
            if(a[m] == x){
                l = m + 1;
                ans = m;
            }
            else if(a[m] > x){
                r = m -1;
            }
            else l = m +1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt(), k = scn.nextInt();
            int[] a = new int[n];
            for(int  i=0; i<n; ++i){
                a[i] = scn.nextInt();
            }
            Arrays.sort(a);
            long res = 0;
            for(int i = 0; i<n - 1; ++i){
                int x1 = fisrt(a, i, n, k - a[i]);
                int x2 = last(a, i, n, k - a[i]);
                if(x1 != -1 && x2 != -1)
                    res += (x2 - x1 + 1);
            }
            System.out.println(res);
        }

    }
}
