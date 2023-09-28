import java.util.Scanner;

public class xau_con_lon_nhat_J03019 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        int index = 0;

        for(char c = 'z'; c >= 'a'; --c){
            for(int j = index; j <s.length(); ++j){
                if(s.charAt(j) == c){
                    System.out.print(c);
                    index = j;
                }
            }
        }
    }
}
