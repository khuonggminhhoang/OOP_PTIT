import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Comparator;

class NhanVien{
    static HashMap<String, Integer> map = new HashMap<>();
    private String id, name;

    public NhanVien(String id, String name) {
        if(id.substring(0,2).equals("GD")){
            if(!map.containsKey("GD")){
                map.put("GD", 1);
            }
            else {
                id = "NV" + id.substring(2);
            }
        }
        else if(id.substring(0, 2).equals("TP")){
            if(!map.containsKey("TP")){
                map.put("TP", 1);
            }
            else if(map.get("TP") > 2){
                id = "NV" + id.substring(2);
            }
            else{
                map.put(id.substring(0,2), map.get(id.substring(0,2)) + 1);
            }
        }
        else if(id.substring(0, 2).equals("PP")){
            if(!map.containsKey("PP")){
                map.put("PP", 1);
            }
            else if(map.get("PP") > 2){
                id = "NV" + id.substring(2);
            }
            else{
                map.put(id.substring(0,2), map.get(id.substring(0,2)) + 1);
            }
        }
        
        this.id = id;
        this.name = name.trim();
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString(){
        return this.name + " " + this.id.substring(0, 2) + " " + this.id.substring(4) + " " + this.id.substring(2,4);
    }
}

public class liet_ke_nhan_vien_theo_nhom_J05065 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<NhanVien> arr = new ArrayList<>();
        while(t-- >0){
            arr.add(new NhanVien(scn.next(), scn.nextLine()));
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
            String pos = scn.nextLine();
            for(NhanVien x : arr){
                if(x.getId().substring(0,2).equals(pos))
                    System.out.println(x);
            }
            System.out.println();
        }
    }
}
