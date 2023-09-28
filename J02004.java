import java.util.Scanner;

public class J02004 {
    public static boolean checkArr(int[] a, int n){
        for(int i = 0; i < n/2; ++i){
            if(a[i] != a[n-1-i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            int[] a = new int[n];
            for(int i= 0; i<n; ++i) a[i] = scn.nextInt();
            System.out.println(checkArr(a,n) ? "YES" : "NO");
        }
    }
}
