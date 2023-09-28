import java.io.File;
import java.util.Scanner;

class ThiSinh{
    private String name, birthday, id;
    private double theorecticalPoint, praticePoint;

    public static int cnt = 0;
    
    public ThiSinh(String name, String birthday, double theorecticalPoint, double praticePoint) {
        this.id = "PH" + String.format("%02d", ++cnt);
        this.name = nameStd(name);
        this.birthday = dayStd(birthday);
        this.theorecticalPoint = theorecticalPoint;
        this.praticePoint = praticePoint;
    }

    private String nameStd(String s){
        String ans = "";
        String[] arr = s.trim().split("\\s+");
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return ans.substring(0, ans.length() - 1);
    }

    private String dayStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/') sb.insert(0,'0');
        if(sb.charAt(4) == '/') sb.insert(3,'0');
        return sb.toString();
    }

    public int yearOld(){
        return 2021 - Integer.parseInt(birthday.substring(6));
    }

    public long total(){
        double bonus = 0;
        if(this.theorecticalPoint >= 8 && this.praticePoint >= 8) bonus = 1;
        else if(this.theorecticalPoint >= 7.5 && this.praticePoint >= 7.5) bonus = 0.5;
        return Math.round((this.theorecticalPoint + this.praticePoint)/2.0 +  bonus);
    }
    // phân loại
    private String classify(){
        long mark = this.total();
        if(mark < 5) return "Truot";
        else if(mark >= 5 && mark <7) return "Trung binh";
        else if(mark >= 7 && mark <8) return "Kha";
        else if(mark >= 8 && mark <9) return "Gioi";
        else return "Xuat sac";
    }

    @Override
    public String toString(){
        long mark = (this.total() > 10) ? 10 : this.total();
        return this.id + " "+ this.name + " " + this.yearOld() + " " + mark + " " + this.classify();
    }
}

public class xet_tuyen_J07053 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("XETTUYEN.in"));
        int t= scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            ThiSinh ts = new ThiSinh(scn.nextLine(), scn.nextLine(), Double.parseDouble(scn.nextLine()), Double.parseDouble(scn.nextLine()));
            System.out.println(ts);
        }
    }
}
