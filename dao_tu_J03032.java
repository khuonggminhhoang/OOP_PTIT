import java.util.Scanner;

public class dao_tu_J03032 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String s = scn.nextLine();
            String[] arr = s.split("\\s+");
            for(String x : arr){
                for(int i = x.length() - 1; i >=0; --i){
                    System.out.print(x.charAt(i));
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
