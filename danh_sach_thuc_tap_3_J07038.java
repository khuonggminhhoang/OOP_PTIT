import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

class SinhVien{
    private String id, name, classs, email;

    public SinhVien(String id, String name, String classs, String email) {
        this.id = id;
        this.name = nameStd(name);
        this.classs = classs;
        this.email = email;
    }

    private String nameStd(String s){
        String ans = "";
        String[] arr = s.trim().split("\\s+");
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return ans.substring(0,ans.length() - 1);
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

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.classs;
    }
}

class DoanhNghiep{
    private String id, name;
    private int amount;
    
    public DoanhNghiep(String id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

public class danh_sach_thuc_tap_3_J07038{
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("SINHVIEN.in"));
        TreeMap<String, SinhVien> mapSv= new TreeMap<>();
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            String id = scn.nextLine();
            SinhVien sinhvien = new SinhVien(id, scn.nextLine(),scn.nextLine(), scn.nextLine());
            mapSv.put(id, sinhvien);
        }

        scn = new Scanner(new File("DN.in"));
        t = scn.nextInt();
        HashMap<String, DoanhNghiep> mapDn = new HashMap<>();
        while(t-- > 0){
            scn.nextLine();
            String id = scn.nextLine();
            DoanhNghiep doanhnghiep = new DoanhNghiep(id, scn.nextLine(), scn.nextInt());
            mapDn.put(id, doanhnghiep);
        }

        scn = new Scanner(new File("THUCTAP.in"));

        t = Integer.parseInt(scn.nextLine());
        HashMap<String, String> map = new HashMap<>();
        while(t-- > 0){
            String idSv = scn.next();
            String idDn = scn.nextLine().trim();
            if(!map.containsKey(idDn)){
                map.put(idDn, idSv);
            }
            else{
                map.put(idDn, map.get(idDn) + " " + idSv);
            }
        }
        
        t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            String idDn = scn.nextLine();

            System.out.println("DANH SACH THUC TAP TAI " + mapDn.get(idDn).getName() + ":");
            String[] arr = map.get(idDn).split("\\s+");
            Arrays.sort(arr);
            int pivot = mapDn.get(idDn).getAmount();
            int tmp = Math.min(pivot, arr.length);
            for(int i = 0; i<tmp; ++i){
                System.out.println(mapSv.get(arr[i]));
            }
        }

    }
}
