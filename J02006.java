import java.util.Scanner;
import java.util.TreeSet;

public class J02006 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), m = scn.nextInt();
        n+=m;
        TreeSet <Integer> set = new TreeSet<>();
        while(n-- > 0){
            int x = scn.nextInt();
            set.add(x);
        }
        for(int x : set) System.out.print( x + " ");
    }
}
