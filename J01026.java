import java.util.Scanner;

public class J01026 {
    public static boolean perfectSquareNumber(int n){
        if(Math.sqrt(n) == (int) Math.sqrt(n)) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            System.out.println(perfectSquareNumber(n)? "YES" : "NO");
        }

    }
}
