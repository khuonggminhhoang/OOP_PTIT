import java.util.Scanner;

public class so_cac_so_nguyen {
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);
        String s = scn.nextLine();
        int cnt3 = 0, cnt5 = 0;
        for(char x : s.toCharArray()){
            if( x == '3') cnt3++;
            if( x =='5' ) cnt5++;
        }
        if((cnt3 + cnt5) == 3 || (cnt3 + cnt5) == 5){
            System.out.println("YES");
        }
        else System.out.println("NO");
    }
}
