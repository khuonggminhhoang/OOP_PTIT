import java.math.BigInteger;
import java.util.Scanner;

public class tong_so_nguyen_lon_1_J03012 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- >0){
            BigInteger num1 = new BigInteger(scn.next());
            BigInteger num2 = new BigInteger(scn.next());
            System.out.println(num1.add(num2).toString());
        }
    }
}
