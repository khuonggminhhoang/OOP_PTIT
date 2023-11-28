import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class ThiSinh{
    private String id, name;
    private double markMath, markPhys, markChem;
    
    public ThiSinh(String id, String name, double markMath, double markPhys, double markChem) {
        this.id = id;
        this.name = nameStd(name);
        this.markMath = markMath;
        this.markPhys = markPhys;
        this.markChem = markChem;
    }

    private String nameStd(String s){
        String ans = "";
        String[] arr = s.trim().split("\\s+");
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return ans.substring(0, ans.length() - 1);
    }

    public String getId(){
        return this.id;
    }

    public double getPriMark(){
        String tmp = this.id.substring(2,3);
        if(tmp.equals("1")) return 0.5;
        else if(tmp.equals("2")) return 1;
        else return 2.5;
    }

    public double total(){
        return 2 * this.markMath + this.markChem+ this.markPhys + this.getPriMark();
    }

    @Override
    public String toString() {
        double tmp = this.getPriMark();
        String priMark = ((int) tmp == tmp)? ((int)tmp + "") : (tmp + ""); 
        tmp = this.total();
        String total = ((int) tmp == tmp)? ((int)tmp + "") : (tmp + "");
        return this.id + " " + this.name + " "+ priMark + " " + total;
    }
}

public class xac_dinh_danh_sach_trung_tuyen_J05059 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<ThiSinh> arr = new ArrayList<>();
        while(t-- > 0){
            arr.add(new ThiSinh(scn.nextLine(),scn.nextLine(), Double.parseDouble(scn.nextLine()),  Double.parseDouble(scn.nextLine()),  Double.parseDouble(scn.nextLine())));
        }
        
        Collections.sort(arr, new Comparator<ThiSinh>(){
            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
                if(o1.total() > o2.total()){
                    return -1;
                }   
                else if(o1.total() < o2.total()) return 1;
                else return o1.getId().compareTo(o2.getId());
            }
        });
        int piv = scn.nextInt() - 1;
        double markStd = arr.get(piv).total();
        System.out.println(markStd);
        for(ThiSinh x : arr){
            if(x.total() >= markStd){
                System.out.println(x + " TRUNG TUYEN");
            }
            else System.out.println(x + " TRUOT");
        }
    }
}
