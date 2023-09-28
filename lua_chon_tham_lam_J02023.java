import java.util.Scanner;

public class lua_chon_tham_lam_J02023 {
    public static String max(int n, int s){
        String ans = "";
        for(int i=0; i<n; ++i){
            if(s > 9){
                ans += '9';
                s -= 9;
            }
            else{
                ans += s + "";
                s = 0;
            }
        }
        return ans;
    }

    public static String min(int n, int s){
        String ans = "";
        for(int i = 0; i< n-1; ++i){
            if(s > 9){
                ans += '9';
                s -= 9;
            }
            else{
                ans += (s-1) + "";
                s = 1;
            }
        }
        ans += s + "";
        StringBuilder sb = new StringBuilder(ans);
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), s = scn.nextInt();
        if(s > 9*n || s == 0){
            System.out.println(-1 + " " + -1);
            return;
        }
        else{
            System.out.println(min(n,s) + " " + max(n,s));
        }
    }
}
