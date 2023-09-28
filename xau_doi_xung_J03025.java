import java.util.Scanner;

public class xau_doi_xung_J03025 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String s = scn.nextLine();
            int cnt = 0;
            for(int i=0; i < s.length()/2; ++i ){
                if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                    cnt++;
                }
            }
            String ans="";
            if(s.length() % 2 == 0 ){
                if(cnt == 1)
                    ans = "YES";
                else ans = "NO";
            }
            else{
                if(cnt == 1 || cnt == 0){
                    ans = "YES";
                }
                else {
                    ans = "NO";
                }
            }
            System.out.println(ans);
        }
    }
}
