import java.util.Scanner;

public class J02014 {
    public static int solve(int[] a, int n, int sum){
        int tmpSum = 0;
        for(int i=0; i<n-1; ++i){
            tmpSum += a[i];
            if(tmpSum == (sum - a[i+1]-tmpSum)) return i+2;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            int[] a = new int[n];
            int sum = 0;
            for(int i=0; i<n; ++i) {
                a[i] = scn.nextInt();
                sum += a[i];
            }
            System.out.println(solve(a, n, sum));
        }
    }
}
