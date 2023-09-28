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

public class tich_hai_doi_tuong_ma_tran_J04016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();
        Matrix a = new Matrix(n,m);
        a.nextMatrix(sc);
        Matrix b = new Matrix(m,p);
        b.nextMatrix(sc);
        System.out.println(a.mul(b));
    }
}
