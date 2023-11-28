import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeSet;

public class cap_so_nguyen_to_trong_file_1_J07030 {
    public static boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); ++i){
            if(n % i == 0){
                return false;
            }
        }
        return n>1;
    }

    public static void main(String[] args) throws Exception{
        ObjectInputStream input1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream input2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> arr1 = (ArrayList<Integer>) input1.readObject();
        ArrayList<Integer> arr2 = (ArrayList<Integer>) input2.readObject(); 

        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        for(int x : arr1){
            if(isPrime(x) && x < 1000000/2){
                set1.add(x);
            }
        }
        for(int x : arr2){
            if(isPrime(x) && x > 1000000/2){
                set2.add(x);
            }
        }
        for(int x : set1){
            if(set2.contains(1000000 - x)){
                System.out.println(x + " " + (1000000- x));
            }
        }
    }       
}
