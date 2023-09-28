import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class vong_tron_J03037 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Stack<Character> stk = new Stack<>();
        String s = scn.nextLine();
        for(char x : s.toCharArray()){
            if(stk.isEmpty()){
                stk.push(x);
            }
            else{
                if(x == stk.peek()){
                    stk.pop();
                }
                else{
                    stk.push(x);
                }
            }
        }
        int cnt = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i<stk.size(); ++i){
            for(int j= i+1; j<stk.size(); ++j){
                if(stk.get(i) == stk.get(j)){
                    for(int k=i + 1; k < j; ++k){
                        if(set.contains(stk.get(k))){
                            set.remove(stk.get(k));
                        }
                        else set.add(stk.get(k));
                    }
                    cnt += set.size();
                    set.clear();
                }
            }
        }
        System.out.println(cnt/2);
    }
}
/*
 * ABECDAEBCD
 * đếm các phần tử khác nhau trong đoạn 2 kí tự giống nhau
 * sau đó cộng vào biến cnt, vì cấc điểm cắt nhau đc tính 2 lần
 * nên kết quả phải chia 2
 */
// AACCBBDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ
// ABCCBDEADEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ
// ABCCABDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ
