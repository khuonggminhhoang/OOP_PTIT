import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien{
    private String id, name;
    private int mark1, mark2, mark3;

    public static int cnt = 0;

    public SinhVien(String name, int mark1, int mark2, int mark3) {
        this.id = "SV" + String.format("%02d", ++cnt);
        this.name = nameStd(name);
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
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
    
    public String classity(){
        if(this.avgMark() >= 8) return "GIOI";
        else if(this.avgMark() >= 6.5 && this.avgMark() < 8) return "KHA";
        else if(this.avgMark() >= 5 && this.avgMark() < 6.5) return "TRUNG BINH";
        else return "KEM"; 
    }

    public double avgMark(){
        return this.mark1*.25 + this.mark2*.35 + this.mark3*.4;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + String.format("%.2f", this.avgMark()) + " " + this.classity();
    }
}


public class xep_loai_J07055 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("BANGDIEM.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<SinhVien> arr = new ArrayList<>();
        while(t-- > 0){
            arr.add(new SinhVien(scn.nextLine(), Integer.parseInt(scn.nextLine()), Integer.parseInt(scn.nextLine()), Integer.parseInt(scn.nextLine())));
        }
        Collections.sort(arr, new Comparator<SinhVien>(){

            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if(o1.avgMark() > o2.avgMark()){
                    return -1;
                }
                else if(o1.avgMark() < o2.avgMark()){
                    return 1;
                }
                else{
                    return o1.getId().compareTo(o2.getId());
                }
            }
            
        });

        for(SinhVien x : arr){
            System.out.println(x);
        }
    }
}
