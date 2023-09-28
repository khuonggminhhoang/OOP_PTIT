import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class so_nguyen_to_lon_nhat_trong_file_J07029 {
    public static boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n); ++i){
            if(n % i == 0) return false;
        }
        return n>1;
    }
    
    public static void main(String[] args) throws Exception {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) input.readObject();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : a){
            if(isPrime(x)){
                if(!map.containsKey(x)){
                    map.put(x,1);
                }
                else{
                    map.put(x, map.get(x) + 1);
                }
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> arr = new ArrayList<>(map.entrySet());
        arr.sort(Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder()));
        int cnt = 0;
        for(Map.Entry<Integer, Integer> entry : arr){
            if(cnt == 10) break;
            System.out.println(entry.getKey()+ " " + entry.getValue());
            ++cnt;
        }
    }
}
