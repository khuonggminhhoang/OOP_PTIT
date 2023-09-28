import java.util.Scanner;

public class J02010 {
    public static void Step(int[] a, int n){
        for(int i=0; i<n-1; ++i){
            for(int j=i+1; j <n; ++j){
                if(a[i] > a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
            System.out.print("Buoc " + (i+1) + ": ");
            for(int x = 0; x < n; ++x){
                System.out.print(a[x] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; ++i) a[i] = scn.nextInt();
        Step(a, n);
    }
}
