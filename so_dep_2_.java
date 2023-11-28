import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class so_dep_2_ {
    public static boolean check(int n){
        String s = n + "";
        if(s.length() < 2) return false;
        for(int i = 0; i< s.length() - 1; ++i){
            if(s.charAt(i) < s.charAt(i + 1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        ObjectInputStream inp1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream inp2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> arr1 = (ArrayList<Integer>) inp1.readObject();
        ArrayList<Integer> arr2 = (ArrayList<Integer>) inp2.readObject();
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int x : arr1){
            if(check(x)){
                set.add(x);
                if(map1.containsKey(x)){
                    map1.put(x, map1.get(x) + 1);
                }
                else{
                    map1.put(x, 1);
                }
            }
        }

        for(int x : arr2){
            if(check(x)){
                set.add(x);
                if(map2.containsKey(x)){
                    map2.put(x, map2.get(x) + 1);
                }
                else{
                    map2.put(x, 1);
                }
            }
        }

        for(int x : set){
            if(map1.containsKey(x) && map2.containsKey(x)){
                System.out.println(x + " " + map1.get(x) + " " + map2.get(x));
            }
        }
        
    }
}
