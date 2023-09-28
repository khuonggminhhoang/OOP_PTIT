import java.math.BigInteger;
import java.util.Scanner;

public class tong_so_nguyen_lon_2_J03014 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        BigInteger num1 = new BigInteger(scn.next());
        BigInteger num2 = new BigInteger(scn.next());
        System.out.println(num1.add(num2).toString());
    }   
}
