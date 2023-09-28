import java.util.Scanner;

public class J01005 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            int h = scn.nextInt();
            for(int i=1; i<n; ++i){
                System.out.printf("%.6f ",(double) h/Math.sqrt(1.0 *n/i));
            }
            System.out.println();
        }
    }
}
