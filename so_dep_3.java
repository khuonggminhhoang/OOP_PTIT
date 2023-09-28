import java.util.Scanner;

public class so_dep_3 {
    public static boolean stn(String s){
        for(int i=0; i< s.length()/2; ++i){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkPrime(String s){
        for( char x : s.toCharArray()){
            if (x != '2' && x != '3' && x != '5' && x != '7'){
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
            System.out.println((stn(s) && checkPrime(s)) ? "YES" : "NO");
        }
    }
}
