import java.util.Scanner;

public class J01007 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in); 
        long[] a = new long[100];
        a[0] = 0L;
        a[1] = 1L;
        for(int i=2; i<100; ++i){
            a[i] = a[i-1] + a[i-2];
        }
        int t = scn.nextInt();
        while(t-- > 0){
            long n = scn.nextLong();
            int ok = 0;
            for(long x : a){
                if(n == x){
                    System.out.println("YES");
                    break;
                }
                if(x > n) {
                    System.out.println("NO");
                    break;
                }
            }
            
        }
    }
}
