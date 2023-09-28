import java.util.Scanner;
import java.util.TreeSet;

public class tap_tu_rieng_cua_hai_xau_J03009 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            TreeSet <String> set1 = new TreeSet<>();
            TreeSet <String> set2 = new TreeSet<>();
            String s1 = scn.nextLine();
            String[] arr1 = s1.split("\\s+");
            String s2 = scn.nextLine();
            String[] arr2 = s2.split("\\s+");
            for(String x : arr1){
                set1.add(x);
            }
            for(String x : arr2){
                set2.add(x);
            }

            for(String x  : set1){
                if(!set2.contains(x)){
                    System.out.print(x + " ");
                }
            }
            System.out.println();
        }
    }
}
