import java.util.Scanner;

public class J02011 {
    public static void solve(int[] a, int n){
        for(int i=0; i<n-1; ++i){
            int idxMin = i;
            for(int j = i+1; j<n; ++j){
                if(a[j] < a[idxMin]){
                    idxMin = j;
                }
            }
            int tmp = a[i];
            a[i] = a[idxMin];
            a[idxMin] = tmp;
            
            System.out.print("Buoc " + (i+1) + ": ");
            for(int index=0; index<n; ++index) System.out.print(a[index] + " ");
            System.out.println();
            
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a= new int[n];
        for(int i=0; i<n; ++i) a[i] = scn.nextInt();
        solve(a, n);
    }
}
