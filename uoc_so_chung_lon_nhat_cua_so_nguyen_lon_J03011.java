import java.math.BigInteger;
import java.util.Scanner;

public class uoc_so_chung_lon_nhat_cua_so_nguyen_lon_J03011 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            BigInteger num1 = new BigInteger(scn.nextLine());
            BigInteger num2 = new BigInteger(scn.nextLine());
            System.out.println(num1.gcd(num2));
        }      
        
    }
}
