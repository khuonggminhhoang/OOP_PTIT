import java.util.Scanner;

public class so_uu_the_J03024 {
    public static boolean isNum(String s){
        if(s.charAt(0) == '0') return false;
        for(char x : s.toCharArray()){
            if(!Character.isDigit(x)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String s = scn.nextLine();
            if(!isNum(s)){
                System.out.println("INVALID");
            }
            else{
                int cntEven = 0, cntOdd = 0;
                for(char x : s.toCharArray()){
                    if(Integer.parseInt(x + "") % 2 == 0) cntEven++;
                    else cntOdd++;
                }
                if((s.length()%2 == 0 && cntEven > cntOdd) || (s.length()%2 == 1 && cntEven < cntOdd)){
                    System.out.println("YES");
                }
                else System.out.println("NO");
            }
        }
    }
}
