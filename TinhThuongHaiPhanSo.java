import java.util.Scanner;

class PhanSo {
    private long tu, mau;

    private long gcd(long a, long b){
        while(b!= 0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public PhanSo(){}

    public PhanSo(long tu, long mau) {
        long gcd = gcd(tu,mau);
        this.tu = tu/gcd;
        this.mau = mau/gcd;
    }

    public PhanSo Dev(PhanSo o){
        PhanSo ans = new PhanSo();
        ans.tu = this.tu * o.mau;
        ans.mau = this.mau * o.tu;
        long gcd = gcd(ans.tu, ans.mau);
        ans.tu /= gcd;
        ans.mau /= gcd;
        return ans;
    }

    @Override
    public String toString() {
        if(this.tu % this.mau == 0) return this.tu/this.mau + "";
        return this.tu + "/" + this.mau;
    }
}

public class TinhThuongHaiPhanSo {
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        while(scn.hasNext()){
            long x =scn.nextLong(), y = scn.nextLong(), z = scn.nextLong(), t = scn.nextLong();
            if(y == 0 || t == 0) continue;
            PhanSo a = new PhanSo(x,y);
            PhanSo b = new PhanSo(z,t);
            System.out.println(a.Dev(b));
        }
    }
}