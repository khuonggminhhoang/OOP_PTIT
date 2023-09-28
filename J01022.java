import java.util.Scanner;

public class J01022 {
    public static long[] fibo = new long[93];

    public static void solve(int n, long k){
        if(fibo[n] == 1){
            if(n==1) System.out.println(0);
            else System.out.println(1);
            return;
        }
        if(k <= fibo[n-2]){
            solve(n-2,k);
        }
        else{
            solve(n-1, k - fibo[n-2]);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i=2; i<93; ++i){
            fibo[i] = fibo[i-2] + fibo[i-1];
        }

        while(t-- > 0){
            int n = scn.nextInt();
            long k = scn.nextLong();
            solve(n,k);
        }
    }
}
