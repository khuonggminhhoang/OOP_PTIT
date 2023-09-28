import java.util.Scanner;

public class quay_phai_J02035 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n= scn.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n; ++i){
                a[i] = scn.nextInt();
            }

            int pos = -1;
            for(int i=0; i<n-1; ++i){
                if(a[i] > a[i + 1]){
                    pos = i;
                    break;
                }
            }
            System.out.println(pos + 1);
        }
    }
}
