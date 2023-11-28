import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Comparator;

class NhanVien{
    private String id, name;

    public NhanVien(String id, String name) {
        int soHieu = Integer.parseInt(id.substring(4));
        if(id.substring(0,2).equals("GD")){
            if(soHieu > 1){
                id = "NV" + id.substring(2);
            }
        }
        else if(id.substring(0, 2).equals("TP")){
            if(soHieu > 3){
                id = "NV" + id.substring(2);
            }
        }
        else if(id.substring(0, 2).equals("PP")){
            if(soHieu > 3){
                id = "NV" + id.substring(2);
            }
        }
        
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return this.name + " " + this.id.substring(0, 2) + " " + this.id.substring(4) + " " + this.id.substring(2,4);
    }
}

public class tim_kiem_nhan_vien_theo_ten_J05066 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<NhanVien> arr = new ArrayList<>();
        while(t-- >0){
            String s = scn.nextLine();
            String id = s.substring(0,7);
            String name = s.substring(8);
            arr.add(new NhanVien(id, name));
        }   
        Collections.sort(arr, new Comparator<NhanVien>(){
            @Override
            public int compare(NhanVien o1, NhanVien o2){
                if(!o1.getId().substring(2,4).equals(o2.getId().substring(2,4))){
                    return o2.getId().substring(2,4).compareTo(o1.getId().substring(2,4));
                }
                else{
                    return o1.getId().substring(4).compareTo(o2.getId().substring(4));
                }
            }
        });
        int q = Integer.parseInt(scn.nextLine());
        while(q-- > 0){
            String abb = scn.nextLine().toLowerCase();
            for(NhanVien x : arr){
                if(x.getName().toLowerCase().contains(abb))
                    System.out.println(x);
            }
            System.out.println();
        }
    }
}
