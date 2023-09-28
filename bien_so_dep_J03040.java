import java.util.Scanner;

public class bien_so_dep_J03040 {
    public static boolean check1(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(3);
        for(int i=0; i<sb.length() - 1; ++i){
            if(sb.charAt(i) >= sb.charAt(i+1)) return false;
        }
        return true;
    }

    public static boolean check2(String s){
        StringBuilder sb = new StringBuilder(s);
        int pos = 0;
        for(int i=0; i<sb.length(); ++i){
            if(sb.charAt(i) == '.'){
                pos = i;
            }
        }
        if(pos != 0)
            sb.deleteCharAt(pos);
        for(int i=0; i<sb.length() - 1; ++i){
            if(sb.charAt(i) != sb.charAt(i+1)) return false;
        }
        return true;
    } 


    public static boolean check3(String s){
        String s1 = s.substring(0,3);
        String s2 = s.substring(4,6);
        if(check2(s1) && check2(s2)) return true;
        return false;
    }

    public static boolean check4(String s){
        StringBuilder sb = new StringBuilder(s);
        s = sb.deleteCharAt(3).toString();
        for(char x : s.toCharArray()){
            if(x != '6' && x != '8'){
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
            s = s.substring(5,s.length());
           
            if(check1(s) || check2(s) || check3(s) || check4(s)){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}

