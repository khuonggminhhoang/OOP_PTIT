import java.util.Arrays;
import java.util.Scanner;

public class ma_tran_xoan_oc_tang_dan_J02102 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        int[] tmp = new int[n*n];
        for(int i=0; i<n*n; ++i){
            tmp[i] = scn.nextInt();
        }
        Arrays.sort(tmp);
        int index = 0;
        int bod = 0;
        while(bod < n/2){
            for(int j = bod; j < n - bod -1; ++j){
                a[bod][j] = tmp[index++];
            }
            for(int i = bod; i <n - bod - 1; ++i){
                a[i][n - bod - 1] = tmp[index++];
            }
            for(int j = n - bod - 1; j > bod; --j){
                a[n - bod - 1][j] = tmp[index++];
            }
            for(int i = n - bod - 1; i > bod; --i){
                a[i][bod] = tmp[index++];
            }
            bod++;
        }
        if(n%2 != 0){
            a[n/2][n/2] = tmp[index];
        }
        for(int i=0; i<n; ++i){
            for(int j = 0;j<n; ++j){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
