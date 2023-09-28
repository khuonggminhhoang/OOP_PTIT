import java.util.Scanner;

public class phan_tu_ben_phai_dau_tien_lon_hon_J08022 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            int[] a = new int[n];
            for(int  i=0; i<n; ++i){
                a[i] = scn.nextInt();
            } 

            for(int i=0; i<n-1; ++i){
                for(int j = i+1; j <n; ++j){
                    if(a[j] > a[i]){
                        System.out.print(a[j] + " ");
                        break;
                    }
                    else if(j == n-1) System.out.print(-1 + " ");
                }
            }
            System.out.println(-1);
        }
    }
}
