import java.util.Scanner;

public class J01009 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long sum = 0;
        long tmp = 1;
        for(int i=1; i<=n; ++i){
            tmp *=i;
            sum += tmp;
        }
        System.out.println(sum);
    }
}
