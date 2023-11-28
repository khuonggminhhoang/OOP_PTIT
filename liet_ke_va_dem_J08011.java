import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class liet_ke_va_dem_J08011 {
    public static boolean decNum(int n){
        String s = n + "";
        for(int i = 0; i < s.length() - 1; ++i){
            if(s.charAt(i) > s.charAt(i + 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        while(scn.hasNext()){
            int x = scn.nextInt();
            if(decNum(x)){

                if(!map.containsKey(x)){
                    map.put(x, 1);
                }
                else{
                    map.put(x, map.get(x) + 1);
                }
            }
        }

        ArrayList<Map.Entry<Integer, Integer>> arr = new ArrayList<>(map.entrySet());
        Collections.sort(arr, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(Map.Entry<Integer, Integer> x : arr){
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
}
