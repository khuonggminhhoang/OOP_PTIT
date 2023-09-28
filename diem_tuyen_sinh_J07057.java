import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class ThiSinh{
    private String id, name, ethnic;
    private double mark;
    private int area;

    public static int cnt = 0;
    public ThiSinh(String name, double mark, String ethnic, int area){
        this.id = "TS" + String.format("%02d", ++cnt);
        this.name = nameStd(name);
        this.mark = mark;
        this.ethnic = ethnic;
        this.area = area;
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

    public double total(){
        double bonus = 0;
        if(this.area == 1) bonus +=1.5;
        else if (this.area == 2) bonus +=1;
        if(!this.ethnic.equals("Kinh")) bonus += 1.5;
        return this.mark + bonus;
    }

    @Override
    public String toString(){
        String ans = "";
        if(this.total() >= 20.5) ans += "Do";
        else ans += "Truot";
        return this.id + " " + this.name + " " + String.format("%.1f", this.total()) + " "+ ans;
    }
}

public class diem_tuyen_sinh_J07057 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("THISINH.in"));
        int t = scn.nextInt();
        ArrayList<ThiSinh> arr = new ArrayList<>();
        scn.nextLine();
        while(t-- > 0){
            arr.add(new ThiSinh(scn.nextLine(), Double.parseDouble(scn.nextLine()), scn.nextLine(), Integer.parseInt(scn.nextLine())));
        }

        Collections.sort(arr, new Comparator<ThiSinh>(){

            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
                if(o1.total() > o2.total()) return -1;
                else if(o1.total() < o2.total()) return 1;
                else return o1.getId().compareTo(o2.getId());
            }   
            
        });

        for(ThiSinh x : arr){
            System.out.println(x);
        }
    }
}
