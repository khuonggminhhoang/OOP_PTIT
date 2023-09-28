import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeMap;

public class so_khac_nhau_trong_file_3_J07006 {
    public static void main(String[] args) {
        try (
            ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("DATA.in"))) {
            ArrayList<Integer> a = (ArrayList<Integer>) inStream.readObject();
            TreeMap <Integer, Integer> map = new  TreeMap<>();
            for(int x : a){
                if(!map.containsKey(x)){
                    map.put(x,1);
                }
                else{
                    map.put(x, map.get(x) + 1);
                }
            }
            for(Integer x : map.keySet()){
                System.out.println(x + " " + map.get(x));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
