import java.math.BigInteger;
import java.util.Scanner;

public class tim_so_du_J03018 {
    public static int num2(BigInteger num){
        int tmp = num.mod(new BigInteger("4")).intValue();
        switch(tmp){
            case 0: return 1; 
            case 1: return 2; 
            case 2: return 4; 
            case 3: return 3;
        }
        return -1;
    }

    public static int num3(BigInteger num){
        int tmp = num.mod(new BigInteger("4")).intValue();
        switch(tmp){
            case 0: return 1; 
            case 1: return 3; 
            case 2: return 4; 
            case 3: return 2;
        }
        return -1;
    }

    public static int num4(BigInteger num){
        int tmp = num.mod(new BigInteger("2")).intValue();
        switch(tmp){
            case 0: return 1; 
            case 1: return 4; 
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            BigInteger a = new BigInteger(scn.nextLine()); 
            int res = 1 + num2(a) + num3(a) + num4(a);
            System.out.println(res%5);
        }
    }
}
