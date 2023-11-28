import java.util.Scanner;

public class bien_doi_a_b_J03030 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        int a = 0, b = 0;
        for(char x : s.toCharArray()){
            if(x == 'A'){
                b = (a < b ? a:b) + 1;
            }
            else{
                a = (a < b ? a:b) + 1;
            }
        }
        System.out.println(a);
    }
}
