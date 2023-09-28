import java.util.Scanner;

public class so_dep_2 {
    public static boolean stn(String s){
        for(int i=0; i< s.length()/2; ++i){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static int sumDigit(String s){
        int sum = 0;
        for(char x : s.toCharArray()){
            sum += (x - '0');
        }
        return sum;
    }

    public static boolean check8(String s){
        if(s.charAt(0) == '8' && s.charAt(s.length()-1) == '8'){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String s = scn.nextLine();
            if(stn(s) && sumDigit(s) % 10 == 0 && check8(s)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
