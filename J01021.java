import java.util.Scanner;

public class J01021 {
    public static int mod = (int)1e9 + 7;
    public static long pow(long a, long b){
        long ans = 1;
        while(b!=0){
            if(b%2 == 1){
                ans *= a;
                ans %= mod;
            }
            b /= 2;
            a *= a;
            a %= mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long a;
        long b;
        while(true){
            a = scn.nextLong();
            b = scn.nextLong();
            if(a == 0 && b==0) return;
            System.out.println(pow(a,b));
        }
        
    }
}
