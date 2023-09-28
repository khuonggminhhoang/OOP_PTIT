import java.util.Scanner;

class Matrix {
    private int[][] a;
    private int row, col;

    Matrix(int row, int col){
        this.row = row;
        this.col = col;
        a = new int[row][col];
    }

    public void nextMatrix(Scanner sc){
        for(int i=0; i<this.row; ++i){
            for(int j=0; j<this.col; ++j){
                this.a[i][j] = sc.nextInt();
            }
        }
    }

    public Matrix mul(Matrix secondMatrix){
        Matrix ans = new Matrix(this.row, secondMatrix.col);
        for(int i=0; i< this.row; ++i){
            for(int j=0; j< secondMatrix.col; ++j){
                for(int k = 0; k< this.col; ++k){
                    ans.a[i][j]  += this.a[i][k] * secondMatrix.a[k][j];
                }
            }
        }
        return ans;
    } 

    public Matrix trans(){
        Matrix ans = new Matrix(this.col, this.row);
        for(int i=0 ; i < this.col; ++i){
            for(int j=0; j<this.row; ++j){
                ans.a[i][j] = this.a[j][i];
            }
        }
        return ans;
    }

    @Override
    public String toString(){
        String ans = "";
        for(int i=0; i < a.length; ++i){
            for(int x : a[i]){
                ans += x + " ";
            }
            ans += "\n";
        }
        return ans;
    }
}

public class tich_ma_tran_va_chuyen_vi_cua_no_J04017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt(), m = sc.nextInt();
            Matrix a = new Matrix(n,m);
            a.nextMatrix(sc);
            Matrix b = a.trans();
            System.out.println(a.mul(b));
        }
    }
}
