import java.util.Scanner;
import java.util.Stack;

public class rut_gon_xau_ky_tu_J03027 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        Stack<Character> stk = new Stack<>();
        for(int i= s.length() - 1; i >= 0; --i){
            if(!stk.isEmpty() && s.charAt(i) == stk.peek()){
                stk.pop();
            }
            else{
                stk.push(s.charAt(i));
            }
        }
        if(stk.isEmpty()){
            System.out.println("Empty String");
            return;
        }
        String ans = "";
        while(!stk.isEmpty()){
            ans+= stk.pop();
        }
        System.out.println(ans);
    }
}
