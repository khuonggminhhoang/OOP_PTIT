import java.util.Scanner;

public class J01010 {
    public static void check(String s){
        String ans = "";
        
        for(char x : s.toCharArray()){
            if(x == '0' || x == '8' || x == '9'){
                ans += '0';
            }
            else if(x == '1'){
                ans += '1';
            }
            else{
                ans = "INVALID";
                break;
            }
        }

        if( ans.equals("INVALID") == false ){
            if( Long.parseLong(ans) != 0){
                System.out.println(Long.parseLong(ans));
            }
            else{
                System.out.println("INVALID");
            }
        }
        else System.out.println(ans);

        
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String s = scn.nextLine();
            check(s);
        }
    }
}
