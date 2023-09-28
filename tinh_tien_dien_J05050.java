import java.util.Scanner;

class KhachHang{
    private String id, SD;
    private long oldest, latest;

    public static int cnt = 0;
    public KhachHang(String SD, long oldest, long latest) {
        this.id = "KH" + String.format("%02d", ++cnt);
        this.SD = SD;
        this.oldest = oldest;
        this.latest = latest;
    }
    //he so
    public long coef(){
        if(this.SD.equals("KD")) return 3;
        else if(this.SD.equals("NN")) return 5;
        else if(this.SD.equals("TT")) return 4;
        else return 2;
    }

    public long money(){
        return (this.latest- this.oldest) * coef() * 550;
    }

    public long bonus(){
        long tmp = this.latest - this.oldest;
        if(tmp < 50) return 0;
        else if( tmp <= 100) return Math.round(0.35f * money());
        else return  money();
    }

    public long total(){
        return money() + bonus();
    }

    @Override
    public String toString(){
        return this.id + " " + this.coef() + " " + this.money() + " " + this.bonus() + " " + this.total();
    }
}

public class tinh_tien_dien_J05050{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            scn.nextLine();
            KhachHang x = new KhachHang(scn.nextLine(), scn.nextLong(), scn.nextLong());
            System.out.println(x);
        }   
    }
}