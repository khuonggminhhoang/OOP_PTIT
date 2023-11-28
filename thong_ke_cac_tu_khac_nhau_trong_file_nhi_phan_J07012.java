
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class thong_ke_cac_tu_khac_nhau_trong_file_nhi_phan_J07012{
    public static void main(String[] args) throws Exception {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> arr = (ArrayList<String>) input.readObject();
        HashMap<String, Integer> map = new HashMap<>();
        for(String line : arr){
            String[] a = line.trim().toLowerCase().split("\\W+");
            for(String x : a){
                if(!x.equals("")){
                    if(!map.containsKey(x)){
                        map.put(x, 1);
                    }
                    else{
                        map.put(x, map.get(x) + 1);
                    }
                }
            }
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,  new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                if(o1.getValue() != o2.getValue())
                    return o2.getValue() - o1.getValue();
                else
                    return o1.getKey().compareTo(o2.getKey());
            }
        });

        for(Map.Entry<String, Integer> x : list){
            System.out.println(x.getKey() + " " + x.getValue());
        }
    } 
}