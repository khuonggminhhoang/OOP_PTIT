import java.util.Scanner;

class Complex {
    private int real, imag;

    Complex(){}
    Complex(int real, int imag){
        this.real = real;
        this.imag = imag;
    }

    public Complex Add(Complex secondComplex){
        Complex ans = new Complex();
        ans.real = this.real + secondComplex.real;
        ans.imag = this.imag + secondComplex.imag;
        return ans; 
    }
    // (a + bi)(c + di) = (ac - bd) + (ad + bc)i
    public Complex Mul(Complex secondComplex){
        Complex ans = new Complex();
        ans.real = this.real * secondComplex.real - this.imag * secondComplex.imag;
        ans.imag = this.real * secondComplex.imag + this.imag * secondComplex.real; 
        return ans;
    }

    @Override
    public String toString(){
        String res = null ;
        if(this.imag < 0){
            res = this.real + " - " + this.imag * -1 + "i";
        }
        else res =  this.real + " + " + this.imag + "i";
        return res;
    }
}

public class so_phuc_J04018 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            Complex A = new Complex(scn.nextInt(), scn.nextInt());
            Complex B = new Complex(scn.nextInt(), scn.nextInt());
            Complex sum = A.Add(B);
            System.out.print(sum.Mul(A) + ", ");
            System.out.println(sum.Mul(sum));
        }
        scn.close();
    }
}
