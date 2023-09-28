import java.util.Scanner;
import java.util.Stack;

public class day_ngoac_dung_dai_nhat_J08021 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- >0){
            Stack<Integer> stk = new Stack<>();
            stk.push(-1);
            int ans = 0;
            String s = scn.nextLine();
            for(int i=0; i<s.length(); ++i){
                if(s.charAt(i) == '('){
                    stk.push(i);
                }
                else{
                    stk.pop();
                    if(!stk.isEmpty()){
                        int tmp = stk.peek();
                        ans = Math.max(ans, i - tmp);
                    }
                    else{
                        stk.push(i);
                    }
                }
            }
            System.out.println(ans);
        }   
    }
}
