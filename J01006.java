import java.util.Scanner;

public class J01006 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in); 
        long[] a = new long[93];
        a[0] = 0;
        a[1] = 1;
        for(int i=2; i<=92; ++i){
            a[i] = a[i-1] + a[i-2];
        }
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            System.out.println(a[n]);
        }
    }
}
