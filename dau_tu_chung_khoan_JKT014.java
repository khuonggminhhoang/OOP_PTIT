import java.util.Scanner;
import java.util.Stack;

public class dau_tu_chung_khoan_JKT014 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n;++i) a[i] = scn.nextInt();
            int[] res = new int[n];
            
            Stack<Integer> stk = new Stack<>();
            stk.push(-1);
            for(int i=0; i<n; ++i){
                while(stk.peek() != -1 && a[stk.peek()] <= a[i]){
                    stk.pop();
                }
                res[i] = i - stk.peek();
                stk.push(i);
            }

            for(int x : res){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
