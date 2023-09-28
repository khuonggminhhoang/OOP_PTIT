import java.util.Scanner;

public class J01008 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int x = 1; x <= t; ++x){
            int n = scn .nextInt();
            System.out.print("Test " + x + ": ");
            for(int i=2; i <= Math.sqrt(n); ++i){
                int cnt = 0;
                while(n % i ==0 ){
                    n/=i;
                    cnt++;
                }
                if(cnt != 0)
                  System.out.print(i + "(" + cnt + ") ");
            }
            if( n > 1) System.out.println(n + "(1)");
            else System.out.println();
        }
    }
}
