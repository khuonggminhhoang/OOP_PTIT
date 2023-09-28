import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class tach_doi_va_tinhh_tong_J07003 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("C:\\Users\\HP\\OneDrive - ptit.edu.vn\\Documents\\OOP\\OOP PTIT\\src file\\DATA.in"));
        BigInteger num = new BigInteger(scn.nextLine());
        BigInteger target = new BigInteger("10");
        while(num.compareTo(target) >= 0){
            String tmp = num.toString();
            BigInteger num1 = new BigInteger(tmp.substring(0,tmp.length()/2));
            BigInteger num2 = new BigInteger(tmp.substring(tmp.length()/2, tmp.length()));
            num = num1.add(num2);
            System.out.println(num.toString());
        }
    }
}
