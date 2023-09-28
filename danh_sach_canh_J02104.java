import java.util.Scanner;

public class danh_sach_canh_J02104 {
    public static int[][] a = new int[1001][1001];
    public static int n;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        n  = scn.nextInt();
        for(int i=1; i<=n; ++i){
            for(int j=1; j <=n; ++j){
                a[i][j] = scn.nextInt();
            }
        }

        for(int i=1; i <=n; ++i){
            for(int j=i ; j<=n; ++j){
                if(a[i][j] == 1){
                    System.out.println("(" + i + "," + j + ")");
                }
            }
        }
    }
}
