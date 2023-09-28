import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeSet;

public class J07031_cap_so_nguyen_to_trong_file_2 {
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
        TreeSet<Integer> set3 = new TreeSet<>();
        for(int x : arr1){
            if(x < 1000000/2){
                set1.add(x);
            }
            else{
                set2.add(x);
            }
        }

        for(int x : arr2){
            set3.add(x);
        }

        for(int x : set1){
            if(isPrime(x) && set2.contains(1000000 - x) && isPrime(1000000 - x) && !set3.contains(x) && !set3.contains(1000000 - x)){
                System.out.println(x + " " + (1000000 - x));
            }
        }

    }
}
