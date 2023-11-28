import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class tinh_gia_tri_bieu_thuc_J07077 {
    public static int pri(char c){
        if(c == '(' || c == ')') return 0;
        else if (c == '+' || c == '-') return 1;
        else if (c == '*' || c == '/') return 2;
        return 3;
    }

    public static List<String> suffix(String s){
        List<String> lst = new ArrayList<>();
        String num = "";
        Stack<Character> stk = new Stack<>();
        for(char x : s.toCharArray()){
            if(Character.isDigit(x)){
                num += String.valueOf(x);
            }
            else{
                if(!num.isEmpty()){
                    lst.add(num);
                    num = "";
                }
                if(x == '('){
                    stk.push(x);
                }
                else if(x == ')'){
                    while(!stk.isEmpty() && stk.peek() != '('){
                        lst.add(String.valueOf(stk.pop()));
                    }
                    stk.pop();     // xoa dau (
                }
                else{
                    while( !stk.isEmpty() && pri(x) <= pri(stk.peek())){
                        lst.add(String.valueOf(stk.pop()));
                    }
                    stk.push(x);
                }
            }
        }
        if(!num.isEmpty()) lst.add(num);
        while(!stk.isEmpty()){
            lst.add(String.valueOf(stk.pop()));
        }
        return lst;
    }

    public static long calc(List<String> lst){
        Stack<Long> stk = new Stack<>();
        for(String x : lst){
            if(Character.isDigit(x.charAt(0))){
                stk.push(Long.parseLong(x));
            }
            else{
                if(x.equals("+")){
                    long o1 = stk.pop();
                    long o2 = stk.pop();
                    stk.push(o1 + o2);
                }
                else if(x.equals("-")){
                    long o1 = stk.pop();
                    long o2 = stk.pop();
                    stk.push(o2 - o1);
                }
                else if(x.equals("*")){
                    long o1 = stk.pop();
                    long o2 = stk.pop();
                    stk.push(o2 * o1);
                }
                else if(x.equals("/")){
                    long o1 = stk.pop();
                    long o2 = stk.pop();
                    stk.push(o2/o1);
                }
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("BIEUTHUC.in"));
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            String s = scn.nextLine();
            List<String> lst = suffix(s);
            System.out.println(calc(lst));
        }
    }
}
