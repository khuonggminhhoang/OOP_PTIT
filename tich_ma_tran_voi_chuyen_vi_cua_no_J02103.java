import java.util.Scanner;

public class tich_ma_tran_voi_chuyen_vi_cua_no_J02103 {

    // 00 01 02
    // 10 11 12
    // 00 01
    // 10 11
    // 20 21

    public static int[][] chuyenVi(int a[][], int n, int m){
        int[][] ans = new int[m][n];
        for(int i=0; i<n; ++i){
            for(int j=0; j <m; ++j){
                ans[j][i] = a[i][j];
            }
        }
        return ans;
    } 

    public static int[][] Mul(int[][] a, int[][] b, int n, int m){
        int[][] ans = new int[n][n];
        for(int i=0; i<n; ++i){
            for(int j = 0; j<n; ++j){
                for(int  k= 0; k<m; ++k){
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int ind = 1; ind <= t; ++ind){
            int n = scn.nextInt();
            int m = scn.nextInt();
            int[][] a = new int[n][m];
            for(int i=0; i<n; ++i){
                for(int j=0; j<m; ++j){
                    a[i][j] = scn.nextInt();
                }
            }
            int[][] res = new int[m][n] ;
            res = chuyenVi(a, n, m);
            a = Mul(a,res, n, m);
            System.out.println("Test " + ind + ": ");
            for(int i=0; i < n; ++i){
                for(int j = 0; j<n; ++j){
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}