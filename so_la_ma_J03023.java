import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class so_la_ma_J03023 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        while(t-- >0){
            Stack<Character> stk = new Stack<>();
            String s = scn.nextLine();
            int ans = 0;
            for(char x : s.toCharArray()){
                if(stk.isEmpty()){
                    ans += map.get(x);
                    stk.push(x);
                }
                else{
                    if(map.get(x) > map.get(stk.peek())){
                        ans = ans - 2 * map.get(stk.peek()) + map.get(x);
                    }
                    else{
                        ans = ans + map.get(x);
                    }
                    stk.push(x);
                }
            }
            System.out.println(ans);
        }
    }
}
