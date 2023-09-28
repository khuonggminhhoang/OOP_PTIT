import java.util.Scanner;
import java.util.Stack;

public class loai_bo_100_J03017 {
    // public static void main(String[] args) {
    //     Scanner scn = new Scanner(System.in);
    //     int t = scn.nextInt();
    //     scn.nextLine();
    //     while(t-- >0){
    //         String str = scn.nextLine();
    //         Stack<Character> stk = new Stack<>();
    //         int ans = 0;
    //         int cnt = 0;
    //         StringBuilder sb = new StringBuilder(str);
    //         String s = sb.reverse().toString();
    //         for(char x : s.toCharArray()){
    //             if(stk.size() < 2 ){
    //                 stk.push(x);
    //             }
    //             else if( x == '0'){
    //                 if(stk.peek() == '0'){
    //                     stk.pop();
    //                     if(stk.peek() == '0'){
    //                         stk.push('0');
    //                     }
    //                     else{
    //                         stk.push('0');
    //                         cnt = 0;
    //                     }
    //                     stk.push('0');
    //                 }
    //                 else{
    //                     stk.push('0');
    //                     cnt = 0;
    //                 }
    //             }
    //             else {
    //                 char tmp = stk.pop();
    //                 String string = x + "" + tmp + stk.peek();
    //                 if(string.equals("100")){
    //                     stk.pop();
    //                     cnt += 3;
    //                 }
    //                 else{
    //                     stk.push(tmp);
    //                     stk.push(x);
    //                     cnt = 0;
    //                 }
    //                 ans = Math.max(ans, cnt);
    //             }
    //         }
    //         System.out.println(ans);

    //     }   
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1' && s.charAt(i + 1) == '0' && s.charAt(i + 2) == '0'){
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                sb.deleteCharAt(i + 1);
                sb.deleteCharAt(i + 2);
                res += 3;
            }
        }
        System.out.println(res);
    }
}
