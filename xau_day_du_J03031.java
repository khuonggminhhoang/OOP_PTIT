import java.util.HashSet;
import java.util.Scanner;

public class xau_day_du_J03031 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            scn.nextLine();
            String s = scn.nextLine();
            int k = scn.nextInt();
            boolean flag = false;
            HashSet<Character> set = new HashSet<>();
            for(char x : s.toCharArray()){
                set.add(x);
            }
            
            if(set.size() + k >= 26){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            
        }
    }
}
