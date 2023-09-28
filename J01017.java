import java.util.Scanner;

public class J01017 {
    public static boolean check(String s){
        for(int i = 1; i< s.length(); ++i){
            if(Math.abs(s.charAt(i) - s.charAt(i-1)) != 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String s = scn.nextLine();
            System.out.println(check(s) ? "YES" : "NO");
        }
    }
}
