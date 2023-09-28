import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class day_con_tang_dan_J07008 {
    public static int[] a = new int[101], arr = new int[21];
    public static int n;
    public static Vector<Integer> v = new Vector<>();
    public static TreeSet<String> set = new TreeSet<>();

    public static boolean check(Vector <Integer> v){
        if(v.size() <2) return false;
        for(int i=0; i<v.size()-1; ++i){
            if(v.elementAt(i) >= v.elementAt(i+1)) return false;
        }
        return true;
    }

    public static String convertString(Vector <Integer> v){
        String ans = "";
        for(int x : v){
            ans += x + " ";
        }
        return ans;
    }

    public static void Bin(int i){
        for(int j = 0; j<2;++j){
            a[i] = j;
            if(i == n){ 
                v.clear(); 
                for(int k = 1; k <=n; ++k){
                    if(a[k] == 1){
                        v.add(arr[k]);
                    }
                }
                if(check(v)){
                    set.add(convertString(v));
                }
            }
            else 
                Bin(i+1);
        }
    }



    public static void main(String[] args) {
        try {
            Scanner scn = new Scanner(new File("DAYSO.in"));
            n = scn.nextInt();
            set = new TreeSet<>();
            for(int i=1; i<=n; ++i){
                arr[i] = scn.nextInt();
            }
            Bin(1);
            for(String x : set){
                System.out.println(x);
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
