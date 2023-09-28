import java.util.Scanner;

public class J01011 {
    public static long gcd(long a, long b){
        while(b!=0){
            long tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static long lcm(long a, long b){
        return a*b / gcd(a,b);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            long a = scn.nextLong();
            long b = scn.nextLong();
            System.out.println(lcm(a,b) + " " + gcd(a,b));
        }
    }
}
