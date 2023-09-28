import java.math.BigInteger;
import java.util.Scanner;

public class boi_so_chung_nho_nhat_J03033 {
    public static BigInteger lcm(BigInteger a, BigInteger b){
        return a.multiply(b).divide(a.gcd(b));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String a = scn.nextLine();
            String b = scn.nextLine();
            BigInteger num1 = new BigInteger(a);
            BigInteger num2 = new BigInteger(b);
            System.out.println(lcm(num1, num2));
        }
        scn.close();
    }
}
