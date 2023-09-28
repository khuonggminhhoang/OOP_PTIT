import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class so_nguyen_to_trong_file_nhi_phan_J07015 {
    public static boolean isPrime(int n){
        for(int i=2; i<= Math.sqrt(n); ++i){
            if(n%i == 0) return false;
        }
        return n > 1;
    }
    
    public static void main(String[] args) {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
            ArrayList<Integer> a = (ArrayList<Integer>) input.readObject();
            int[] arr = new int[10001];
            for(int x : a){
                if(isPrime(x)){
                    arr[x]++;
                }
            }
            for(int i=0; i<10001; ++i){
                if(arr[i] > 0){
                    System.out.println(i +" " + arr[i]);
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
