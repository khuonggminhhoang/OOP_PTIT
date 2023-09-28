import java.util.Scanner;

class Fraction{
    private long numerator, denominator;

    private long gcd(long a, long b){
        while( b!= 0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public Fraction(){}

    public Fraction(long numerator, long denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString(){
        long gcd = gcd(this.numerator, this.denominator);
        return this.numerator / gcd + "/" + this.denominator / gcd;
    }


}

public class phan_so_J04003 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Fraction p = new Fraction(scn.nextLong(), scn.nextLong());
        System.out.println(p);
    }
}
