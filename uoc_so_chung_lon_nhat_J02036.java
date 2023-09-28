import java.util.Scanner;

public class uoc_so_chung_lon_nhat_J02036 {
    public static int gcd(int a, int b){
        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }

    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            int n = scn.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n; ++i) a[i] = scn.nextInt();
            System.out.print(a[0] + " ");
            for(int i=0; i<n-1; ++i){
                System.out.print(lcm(a[i], a[i+1]) + " ");
            }
            System.out.println(a[n-1]);
        }
    } 
}
