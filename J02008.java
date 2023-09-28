import java.util.Scanner;

public class J02008 {
    public static long gcd(long a, long b){
        while(b!=0){
            long tmp = a%b;
            a=b;
            b=tmp;
        }
        return a;
    }

    public static long lcm(long a, long b){
        return  a*b / ( gcd(a,b));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long t = scn.nextInt();

        while(t-- > 0){
            long n = scn.nextInt();
            long ans = 1;
            for(int i=1; i<=n; ++i){
                ans = lcm(ans,i);
            }
            System.out.println(ans);
        }
    }
}
