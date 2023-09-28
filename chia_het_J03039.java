import java.math.BigInteger;
import java.util.Scanner;

public class chia_het_J03039 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            BigInteger a = new BigInteger(scn.next());
            BigInteger b = new BigInteger(scn.next());
            boolean check = false;
            if ("0" == a.mod(b).toString()) {
                check = true;
            }
            else if ("0" == b.mod(a).toString()) {
                check = true;
            }
            System.out.println(check ? "YES" : "NO");
        }
    }
}
