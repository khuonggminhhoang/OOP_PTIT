import java.util.Scanner;

public class J02021 {
    public static int[] x = new int[11];
    public static int k,n, cnt = 0;
    public static void print(int[] x){
        for(int i = 1; i<=k; ++i){
            System.out.print(x[i]);
        }
        System.out.print(" ");
    }

    public static void Try(int i){
        for(int j = x[i-1] + 1; j <= n-k +i; ++j){
            x[i] = j;
            if(i == k){
                print(x);
                cnt++;
            }
            else
                Try(i+1);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        k = scn.nextInt();
        Try(1);
        System.out.print("\nTong cong co " + cnt + " to hop");
    }
}
