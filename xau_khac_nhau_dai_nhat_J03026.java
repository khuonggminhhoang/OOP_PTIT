import java.util.Scanner;
import java.util.*;

public class xau_khac_nhau_dai_nhat_J03026 {
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String s1 = scn.nextLine(), s2 = scn.nextLine();
            if(s1.length() == s2.length()){
                if(s1.equals(s2)){
                    System.out.println(-1);
                }
                else{
                    System.out.println(s1.length());
                }
            }
            else{
                System.out.println(Math.max(s2.length(), s1.length()));
            }
        }
    }
    
}
