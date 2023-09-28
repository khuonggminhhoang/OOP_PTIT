import java.util.Scanner;

public class J02013 {
    public static void bubleSort(int[] a, int n){
        int cnt = 0;
        boolean flag;
        for(int i=0; i<n; ++i){
            flag = false;
            for(int j=0; j<n-1-i; ++j){
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if(flag){
                System.out.print("Buoc " + ++cnt + ": ");
                for(int id=0; id<n; ++id) System.out.print(a[id] + " ");
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; ++i) a[i] = scn.nextInt();
        bubleSort(a, n);
    }
}
