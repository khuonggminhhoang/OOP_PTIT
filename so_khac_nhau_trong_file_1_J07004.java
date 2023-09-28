import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class so_khac_nhau_trong_file_1_J07004 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new  File("DATA.in"));
        TreeMap <Integer, Integer> map = new TreeMap<>();
        while(scn.hasNext()){
            int x = scn.nextInt();
            if(!map.containsKey(x)){
                map.put(x,1);
            }
            else{
                int tmp = map.get(x);
                ++tmp;
                map.put(x,tmp);
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for( Map.Entry<Integer, Integer> entry : entrySet){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        
    }
}
