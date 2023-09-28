import java.util.Scanner;

public class J02012 {
    public static void insertionSort(int[] a, int n){
        for(int i=0; i<n; ++i){
            int pos = i-1;
            int x = a[i];
            int step = pos+1;
            while(pos >= 0 && a[pos] > x){
                a[pos + 1] = a[pos];
                --pos;
            }
            a[pos + 1] = x;
            System.out.print("Buoc " + i + ": ");
            for(int index = 0; index <= step; ++index) System.out.print(a[index]+ " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a= new int[n];
        for(int i=0; i<n; ++i) a[i] = scn.nextInt();
        insertionSort(a, n);
    }
}
