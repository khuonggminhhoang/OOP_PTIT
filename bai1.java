import java.util.ArrayList;
import java.util.Scanner;

class ThiSinh{
    private String ma,ten,dantoc;
    private double toan,ly,hoa;
    private int giai;
    public ThiSinh(String ma,String ten,String dantoc,double toan,double ly,double hoa,int giai){
        this.ma=ma;
        this.ten=ten;
        this.dantoc=dantoc;
        this.toan=toan;
        this.ly=ly;
        this.hoa=hoa;
        this.giai=giai;
    }
    public String getMa(){
        return ma;
    }
    public void setMa(String ma){
        this.ma=ma;
    }
    public String getTen(){
        return ten;
    }
    public void setTen(String ten){
        this.ten=ten;
    }
    public String getDantoc(){
        return dantoc;
    }
    public void setDantoc(String dantoc){
        this.dantoc=dantoc;
    }
    public double getToan(){
        return toan;
    }
    
    public void settoan(double toan){
        this.toan =toan;

    }
    public double getly(){
        return ly;
    }
    public void setLy(double ly){
        this.ly=ly;


    }
    public double sethoa(){
        return hoa;
    }
    public void gethoa(int hoa){
        this.hoa=hoa;
    }
    public int getgiai(){
        return giai;
    }
    public void setgiai(int giai){
        this.giai=giai;
    }
    public double uutien(){
        int a=0;
        if(this.ma.substring(2,3 ).equals("2")) a=1;
        else if (this.ma.substring(2,3 ).equals("3")) a=2;
        else a=0;
        if(!this.dantoc.toLowerCase().equals("kinh")){
            a+=1;
        }
        if(this.giai==1) a+=1.5;
        else if (this.giai==2) a+=1;
        else if (this.giai==3) a+=0.5;
        return a;

    }
    public double total(){
        return this.toan+this.ly+this.hoa+uutien();
    }

    @Override
    public String toString(){
        String tmp= total() >= 26.8?"TRUNG TUYEN": "TRUOT";
        String tmp_ = (int)uutien() == uutien() ? (int)uutien()+"":uutien()+"";
        String temp = (int)(total())-uutien()==(total()-uutien())?(int)(total()-uutien())+"":(int)(total()-uutien())+"";
        return this.ma+" "+this.ten+" "+tmp_+" "+temp+" "+tmp;
    }

    
}


public class bai1 {
    public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int t = scn.nextInt();
         ArrayList<ThiSinh>arr  = new ArrayList<>();
         while(t-->0){
            scn.nextLine();
            ThiSinh x = new ThiSinh(scn.nextLine(),scn.nextLine(),scn.nextLine(),scn.nextDouble(),scn.nextDouble(),scn.nextDouble(),scn.nextInt());
            arr.add(x);
         }
         scn .nextLine();
         double mark = scn.nextDouble();
         for(ThiSinh x :arr){
            if(x.uutien()==0&& x.total()>=mark){
                System.out.println(x);
            }
         }
    }
    
}