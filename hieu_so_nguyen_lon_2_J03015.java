import java.math.BigInteger;
import java.util.Scanner;

public class hieu_so_nguyen_lon_2_J03015 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        BigInteger num1 = new BigInteger(scn.nextLine());
        BigInteger num2 = new BigInteger(scn.nextLine());
        System.out.println(num1.subtract(num2));
        
    }
}
