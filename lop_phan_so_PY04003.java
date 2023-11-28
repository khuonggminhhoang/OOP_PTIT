import java.util.Scanner;

class PhanSo{
    private long tuso, mauso;

    public PhanSo(long tuso, long mauso) {
        this.tuso = tuso;
        this.mauso = mauso;
    }

    private long gcd(long a, long b){
        while(b != 0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    @Override
    public String toString(){
        long gcd = this.gcd(this.tuso, this.mauso);
        return (this.tuso/gcd) + "/" + (this.mauso/gcd);
    }
}

public class lop_phan_so_PY04003 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        PhanSo x = new PhanSo(scn.nextLong(), scn.nextLong());
        System.out.println(x); 
    }
}
