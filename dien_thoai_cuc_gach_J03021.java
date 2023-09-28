import java.util.Scanner;

public class dien_thoai_cuc_gach_J03021 {
    public static String convertNum(String s){
        String ans = "";
        s = s.toLowerCase();
        for(char x : s.toCharArray()){
            if( x == 'a' || x == 'b' || x == 'c'){
                ans += '2';
            }
            else if(x == 'd' || x == 'e' || x == 'f'){
                ans += '3';
            }
            else if(x == 'g' || x == 'h' || x == 'i'){
                ans += '4';
            }
            else if(x == 'j' || x == 'k' || x == 'l'){
                ans += '5';
            }
            else if(x == 'm' || x == 'n' || x == 'o'){
                ans += '6';
            }
            else if(x == 'p' || x == 'q' || x == 'r' || x == 's'){
                ans += '7';
            }
            else if(x == 't' || x == 'u' || x == 'v'){
                ans += '8';
            }
            else if(x == 'w' || x == 'x' || x == 'y' || x == 'z'){
                ans += '9';
            }
        }
        return ans;
    }

    public static boolean check(String s){
        for(int i=0; i<s.length()/2; ++i){
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String s = scn.nextLine();
            System.out.println((check(convertNum(s))) ? "YES" : "NO");
        }
    }
}
