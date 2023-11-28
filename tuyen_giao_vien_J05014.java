import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class GiaoVien{
    private String id, name, code;
    private double inft, major;

    public static int cnt = 0;

    public GiaoVien(String name, String code, double inft, double major) {
        this.id = "GV" + String.format("%02d", ++cnt);
        this.name = name;
        this.code = code;
        this.inft = inft;
        this.major = major;
    }

    public String getId(){
        return this.id;
    }

    public double priority(){
        char c = this.code.charAt(1);
        if(c == '1') return 2.0;
        else if(c == '2') return 1.5;
        else if(c == '3') return 1.0;
        else return 0;
    }

    public String subject(){
        char c = this.code.charAt(0);
        if(c == 'A') return "TOAN";
        else if(c == 'B') return "LY";
        else return "HOA";
    }

    public double total(){
        return this.inft * 2 + this.major + priority();
    }

    public String classify(){
        if(total() >= 18) return "TRUNG TUYEN";
        else return "LOAI";
    }

    @Override
    public String toString(){
        return this.id  + " " + this.name + " " + this.subject() + " " + String.format("%.1f", total()) + " " + this.classify(); 
    }
}

public class tuyen_giao_vien_J05014 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<GiaoVien> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arr.add(new GiaoVien(scn.nextLine(), scn.nextLine(), scn.nextDouble(), scn.nextDouble()));
        }   
        Collections.sort(arr, new Comparator<GiaoVien>(){
            @Override
            public int compare(GiaoVien o1, GiaoVien o2){
                if(o1.total() != o2.total()){
                    return Double.compare(o2.total(), o1.total());
                }
                else return o1.getId().compareTo(o2.getId());
            }
        });

        for(GiaoVien x : arr){
            System.out.println(x);
        }
    }
}

