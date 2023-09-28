import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public class so_thuan_nghich_trong_file_J07032 {
    public static boolean palin(int n){
        String num = n + "";
        StringBuilder sb = new StringBuilder(num);
        return sb.reverse().toString().equals(num);
    }

    public static boolean isAllOddDigit(int n){
        String num = n + "";
        for(char x : num.toCharArray()){
            if(x != '1' && x != '3' && x !='5' && x != '7' && x !='9'){
                return false;
            }
        }
        return true;
    }

    public static boolean checkAllCondition(int n){
        String num = n + "";
        return num.length() > 1 && num.length() % 2 == 1 && palin(n) && isAllOddDigit(n);
    }

    public static void main(String[] args) throws Exception{
        ObjectInputStream input1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream input2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> arr1 = (ArrayList<Integer>) input1.readObject();
        ArrayList<Integer> arr2 = (ArrayList<Integer>) input2.readObject();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        HashSet<Integer> set1 = new HashSet<>(); 
        HashSet<Integer> set2 = new HashSet<>(); 

        for(int x : arr1){
            if(checkAllCondition(x)){    
                set1.add(x);
                if(!map.containsKey(x)){
                    map.put(x, 1);
                }
                else{
                    map.put(x, map.get(x) + 1);
                }
            }
        }

        for(int x : arr2){
            if(checkAllCondition(x)){
                set2.add(x);
                if(!map.containsKey(x)){
                    map.put(x, 1);
                }
                else{
                    map.put(x, map.get(x) + 1);
                }
            }
        }

        int cnt = 0;
        for(int x : map.keySet()){
            if(cnt ==10 ) break;
            if(set1.contains(x) && set2.contains(x)){
                System.out.println(x + " " + map.get(x));
                ++cnt;
            }
        }
    }
}
