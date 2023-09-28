import java.util.Arrays;
import java.util.Scanner;

public class khoang_cach_nho_hon_k_J02027 {
    public static int lowerBound(int[] a, int index, int n, int x){
        int left = index, right = n-1;
        
        while(left <= right){
            int mid = (left + right)/2;
            if(a[mid] >= x){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            int n = scn.nextInt(), k = scn.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n;++i) a[i] = scn.nextInt();
            Arrays.sort(a);
            long res = 0;
            for(int i = 0; i< n - 1; ++i){
                int tmp = a[i]  + k;
                int idx = lowerBound(a,i + 1, n, tmp);
                res += (idx -i -1);
            }
            System.out.println(res);
        }
    }
}
