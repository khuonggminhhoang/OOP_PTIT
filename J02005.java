import java.util.TreeSet;
import java.util.Scanner;

public class J02005 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), m = scn.nextInt();
        TreeSet <Integer> set1 = new TreeSet<>();
        TreeSet <Integer> set2 = new TreeSet<>();
        while(n-- > 0){
            int x = scn.nextInt();
            set1.add(x);
        }
        while(m-- > 0){
            int x = scn.nextInt();
            set2.add(x);
        }

        for(int x : set1){
            if(set2.contains(x)){
                System.out.print(x + " ");
            }
        }
        
    }
}
