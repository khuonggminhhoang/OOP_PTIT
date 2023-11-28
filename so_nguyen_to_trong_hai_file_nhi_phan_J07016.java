import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeMap;

public class so_nguyen_to_trong_hai_file_nhi_phan_J07016 {
    public static boolean[] prime = new boolean[10001];

    public static void seive(){
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i<10001; ++i){
            prime[i] = true;
        }

        for(int i = 2; i <= Math.sqrt(10001); ++i){
            if(prime[i]){
                for(int j = i*i; j < 10001; j += i){
                    prime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        seive();
        ObjectInputStream input1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream input2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> arr1 = (ArrayList<Integer>)input1.readObject();
        ArrayList<Integer> arr2 = (ArrayList<Integer>)input2.readObject();
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        for(int x : arr1){
            if(prime[x]){
                if(!map1.containsKey(x)){
                    map1.put(x, 1);
                }
                else{
                    map1.put(x, map1.get(x) + 1);
                }
            }
        }

        for(int x : arr2){
            if(prime[x]){
                if(!map2.containsKey(x)){
                    map2.put(x, 1);
                }
                else{
                    map2.put(x, map2.get(x) + 1);
                }
            }
        }

        for(int x : map1.keySet()){
            if(map2.containsKey(x)){
                System.out.println(x + " " + map1.get(x) + " " + map2.get(x));
            }
        }
    }
}
