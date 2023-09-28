import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class sap_xep_ma_tran_J07076 {
    public static int[][] chuyenVi(int[][] a, int n, int m){
        int[][] ans = new int[m][n];
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                ans[j][i] = a[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("MATRIX.in"));
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt(), m = scn.nextInt();
            int pos = scn.nextInt();
            int[][] a = new int[n][m];
            for(int i=0; i<n;  ++i){
                for(int j=0; j<m; ++j){
                    a[i][j] = scn.nextInt();
                }
            }

            int[][] b = chuyenVi(a, n, m);
            Arrays.sort(b[pos-1]);
            a = chuyenVi(b,m,n);
            for(int i=0; i<n; ++i){
                for(int j=0; j<m; ++j){
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
