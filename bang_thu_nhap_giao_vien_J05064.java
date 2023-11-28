import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class GiaoVien{
    private String id, name;
    private long basicSalary;
    public GiaoVien(String id, String name, long basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getBasicSalary() {
        return basicSalary;
    }
    public void setBasicSalary(long basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int bonus(){
        String s = this.id.substring(0,2);
        if(s.equals("HT")) return 2000000;
        else if(s.equals("HP")) return 900000;
        else return 500000;
    }

    public long income(){
        return this.basicSalary * Integer.parseInt(this.id.substring(2)) + bonus();
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + Integer.parseInt(this.id.substring(2)) + " " + this.bonus() + " " + this.income();
    }
}

public class bang_thu_nhap_giao_vien_J05064 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<GiaoVien> arr = new ArrayList<>();
        map.put("HT",0);
        map.put("HP", 0);
        while(t-- >0){
            scn.nextLine();
            GiaoVien giaovien = new GiaoVien(scn.nextLine(), scn.nextLine(), scn.nextLong());
            if(giaovien.getId().substring(0,2).equals("HT")){
                if(map.get("HT") < 1){
                    arr.add(giaovien);
                    map.put("HT", map.get("HT") + 1);
                }
            }
            else if(giaovien.getId().substring(0,2).equals("HP")){
                if(map.get("HP") < 2){
                    arr.add(giaovien);
                    map.put("HP", map.get("HP") + 1);
                }
            }
            else arr.add(giaovien);
        }   
        for(GiaoVien x : arr){
            System.out.println(x);
        }
    }
}