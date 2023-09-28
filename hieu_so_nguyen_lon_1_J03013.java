import java.math.BigInteger;
import java.util.Scanner;

public class hieu_so_nguyen_lon_1_J03013 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            String s1 = scn.next(), s2 = scn.next();
            BigInteger num1 = new BigInteger(s1);
            BigInteger num2 = new BigInteger(s2);
            String ans = num1.subtract(num2).abs() + "";
            int max = Math.max(s1.length(), s2.length());
            max -= ans.length();
            String zeros = "";
            while(max-- > 0){
                zeros += '0';
            }
            System.out.println(zeros + ans);
        }      
    }
}
