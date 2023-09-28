import java.util.Scanner;

public class so_dep_1_J03006 {
    public static boolean stn(String s){
        for(int i=0; i< s.length()/2; ++i){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkEvenDigit(String s){
        for(char x : s.toCharArray()){
            if(x != '0' && x != '2' && x != '4' && x != '6' && x != '8')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            String s = scn.nextLine();
            System.out.println((stn(s) && checkEvenDigit(s)) ? "YES":"NO");
        }

    }
}

