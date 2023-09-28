import java.util.LinkedHashMap;
import java.util.Scanner;

public class tim_tu_thuan_nghich_dai_nhat_J03020 {
    public static boolean palin(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        int max = -1;
        while(scn.hasNext()){
            String x = scn.next();
            if(palin(x)){
                max = Math.max(max, x.length());
                if(!map.containsKey(x)){
                    map.put(x,1);
                }
                else{
                    map.put(x, map.get(x) + 1);
                }
            }
        }
        for(String x : map.keySet()){
            if(max == x.length()){
                System.out.println(x + " " + map.get(x));
            }
        }
    }
}

