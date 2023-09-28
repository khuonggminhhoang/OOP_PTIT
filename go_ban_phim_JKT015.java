import java.util.Scanner;
import java.util.Stack;

public class go_ban_phim_JKT015 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
        for(char x : s.toCharArray()){
            if(x == '-'){
                if(!stk1.isEmpty()){
                    stk1.pop();
                }
            }
            else if(x == '<'){
                if(!stk1.isEmpty()){
                    stk2.push(stk1.pop());
                }
            }
            else if(x == '>'){
                if(!stk2.isEmpty()){
                    stk1.push(stk2.pop());
                }
            }
            else stk1.push(x);
        }

        while(!stk2.isEmpty()){
            stk1.push(stk2.pop());
        }
        for(char x : stk1){
            System.out.print(x);
        }
    }
}
