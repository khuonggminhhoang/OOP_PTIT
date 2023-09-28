import java.util.Scanner;

public class J01024 {
    public static boolean check(String s){
        for(char x : s.toCharArray()){
            if(x != '0' && x != '1' && x != '2') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            String s = scn.nextLine();
            System.out.println(check(s) ? "YES" : "NO");
        }
    }
}
