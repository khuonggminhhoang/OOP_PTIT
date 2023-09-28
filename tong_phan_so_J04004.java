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

    static Fraction sum(Fraction f1, Fraction f2){
        Fraction ans = new Fraction();
        ans.numerator = f1.numerator * f2.denominator + f1.denominator * f2.numerator;
        ans.denominator = f1.denominator * f2.denominator;
        return ans;
    }

    @Override
    public String toString(){
        long gcd = gcd(this.numerator, this.denominator);
        return this.numerator / gcd + "/" + this.denominator / gcd;
    }
}

public class tong_phan_so_J04004 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Fraction f1 = new Fraction(scn.nextLong(), scn.nextLong());
        Fraction f2 = new Fraction(scn.nextLong(), scn.nextLong());
        System.out.println(Fraction.sum(f1, f2));
    }
}
