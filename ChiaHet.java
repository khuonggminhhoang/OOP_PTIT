import java.math.BigInteger;
import java.util.Scanner;

public class ChiaHet {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            BigInteger a = new BigInteger(scn.next());
            BigInteger b = new BigInteger(scn.next());
            BigInteger c = new BigInteger(scn.next());
            boolean check1 = false;
            boolean check2 = false;
            if (a.mod(c).toString() == "0") {
                check1 = true;
            }
            if (b.mod(c).toString() == "0") {
                check2 = true;
            }
            System.out.println((check1 && check2) ? "YES" : "NO");
        }
    }
}
