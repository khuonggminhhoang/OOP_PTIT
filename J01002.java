import java.util.Scanner;

public class J01002 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            System.out.println(1l *(n+1)*n/2);
        }
    }
}
