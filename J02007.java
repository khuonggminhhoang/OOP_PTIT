import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class J02007 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int i=1; i<=t ; ++i){
            int n = scn.nextInt();
            LinkedHashMap <Integer, Integer> map = new LinkedHashMap<>();
            while(n-- > 0){
                int x = scn.nextInt();
                if(!map.containsKey(x)){
                    map.put(x,1);
                }
                else{
                    int tmp = map.get(x);
                    tmp++;
                    map.put(x,tmp);
                }
            }
            System.out.println("Test " + i + ":");
            Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
            for(Map.Entry<Integer, Integer> entry : entrySet){
                System.out.println(entry.getKey() + " xuat hien " + entry.getValue() + " lan");
            }
        }
    }
}
