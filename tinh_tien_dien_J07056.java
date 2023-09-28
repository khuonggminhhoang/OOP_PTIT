import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class KhachHang{
    private String id, name;
    private char c;
    private int start, end;

    public static int cnt = 0;
    public KhachHang(String name, char c, int start, int end) {
        this.id = "KH" + String.format("%02d", ++cnt);
        this.name = nameStd(name);
        this.c = c;
        this.start = start;
        this.end = end;
    }

    private String nameStd(String s){
        String ans = "";
        String[] arr = s.trim().split("\\s+");
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return ans.substring(0, ans.length() - 1);
    }

    public int norm(){
        if(this.c == 'A') return 100;
        else if(this.c == 'B') return 500;
        else return 200;
    }

    public int inNorm(){
        int amount = this.end - this.start;
        if(amount < norm()) return amount * 450;
        else return this.norm() * 450;
    }

    public int overNorm(){
        int ans = 0;
        int amount = this.end - this.start;
        if(amount > norm()){
            ans = (amount - norm()) * 1000;
        }
        return ans;
    }

    public int VAT(){
        return this.overNorm() * 5 / 100;
    }

    public int total(){
        return this.inNorm() + this.overNorm() + this.VAT();
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.inNorm() + " " + this.overNorm() + " " + this.VAT() + " " + this.total();
    }
}

public class tinh_tien_dien_J07056 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("KHACHHANG.in"));
        int  t = scn.nextInt();
        ArrayList<KhachHang> arr = new ArrayList<>();
        while(t-- > 0){
            scn.nextLine();
            String name = scn.nextLine();
            char c = scn.next().charAt(0);
            int start = scn.nextInt();
            int end = scn.nextInt();
            arr.add(new KhachHang(name, c, start, end));
        }
        Collections.sort(arr, new Comparator<KhachHang>(){

            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                return o2.total() - o1.total();
            }
        });
        for(KhachHang x : arr){
            System.out.println(x);
        }
    }
}
