import java.util.Scanner;
import java.util.Stack;

public class J02017 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Stack <Integer> stk = new Stack<>();
        while(n-- > 0){
            int x = scn.nextInt();
            if(stk.empty()){
                stk.push(x);
            }
            else{
                int top = stk.pop();
                if((x + top) % 2 != 0){
                    stk.push(top);
                    stk.push(x);
                }
            }
        }
        System.out.println(stk.size());
    }
}
