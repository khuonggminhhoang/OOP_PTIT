import java.io.File;
import java.util.Scanner;

public class tim_vi_tri_xau_con_J07078 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("STRING.in"));
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            String s1 = scn.nextLine();
            String s2 = scn.nextLine();
            int n = s1.length(), m = s2.length();
            for(int i=0; i<= n - m; ++i){
                if(s1.substring(i, i + m).equals(s2)){
                    System.out.print(i + 1 + " ");
                }
            }
            System.out.println();
        }
    }
}
