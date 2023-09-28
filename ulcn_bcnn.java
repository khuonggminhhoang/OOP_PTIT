import java.util.Scanner;

public class ulcn_bcnn {
    public static Scanner sc = new Scanner(System.in);
    public static int gcd(int a,int b){
        while(b!=0){
            int x = a%b;
            a=b;
            b=x;

        }
        return a;
    }
    public static int lcm(int a,int b){
        return a*b/gcd(a, b);
    }

    public static void kqua(){
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a, b)+" "+lcm(a, b));
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-->0){
           kqua();
        }
    }
}