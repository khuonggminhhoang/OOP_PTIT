import java.util.Scanner;

public class J01018 {
    public static boolean check(String s){
        for(int i = 1; i< s.length(); ++i){
            if(Math.abs(s.charAt(i) - s.charAt(i-1)) != 2){
                return false;
            }
        }
        return true;
    }

    public static int sumChar(String s){
        int sum = 0;
        for(char x : s.toCharArray()){
            sum += x - '0';
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String s = scn.nextLine();
            if(check(s) && sumChar(s) % 10 == 0){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}
