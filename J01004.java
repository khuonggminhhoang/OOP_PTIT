import java.util.Scanner;

public class J01004 {
    public static boolean snt(int n){
        for(int i=2; i<= Math.sqrt(n); ++i){
            if(n % i == 0) return false;
        }
        return n > 1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            if(snt(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
