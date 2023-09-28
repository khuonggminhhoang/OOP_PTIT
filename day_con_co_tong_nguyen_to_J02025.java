import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class day_con_co_tong_nguyen_to_J02025 {
    public static int[] bin = new int[15];
    public static int n;

    public static int sum(Integer[] a){
        int sum = 0;
        for(int i=0; i <n; ++i){
            if(bin[i] == 1) sum += a[i];
        }
        return sum;
    }

    public static boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); ++i){
            if(n % i == 0) return false;
        }
        return n > 1;
    }

    public static void Try(int i, Integer[] a){
        for(int j=0; j<2; ++j){
            bin[i] = j;
            if(i == n - 1 ){
                if(isPrime(sum(a))){
                    for(int k = 0; k <n; ++k){
                        if(bin[k] == 1){
                            System.out.print(a[k] + " ");
                        }
                    }
                    System.out.println();
                }
            }
            else Try(i + 1, a);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            n = scn.nextInt();
            Integer[] a = new Integer[n];
            for(int i=0; i<n; ++i){
                a[i] = scn.nextInt();
            }
            Arrays.sort(a, Comparator.reverseOrder());
            Try(0, a);

        }
    }
}
