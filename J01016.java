import java.util.Scanner;

public class J01016 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        int cnt = 0;
        for(char x : s.toCharArray()){
            if(x == '4' || x == '7'){
                cnt++;
            }
        }
        if(cnt == 4 || cnt == 7) System.out.println("YES");
        else System.out.println("NO");
    }
}
