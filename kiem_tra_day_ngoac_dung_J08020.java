import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class kiem_tra_day_ngoac_dung_J08020 {
    public static boolean check(String s){
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stk = new Stack<>();
        for(char x :s.toCharArray()){
            if(stk.isEmpty()){
                if(x == ')' || x == ']'|| x == '}') return false;
                else stk.push(x);
            }
            else{
                if(x == '('|| x == '[' || x == '{'){
                    stk.push(x);
                }
                else{
                    if(stk.peek() != map.get(x)) return false;
                    else stk.pop();
                }
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
            System.out.println((check(s)) ? "YES" : "NO");

        }
    }
}
