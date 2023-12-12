/*
 * Note: bài này muốn ac phải nén zip
 */
package test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 *
 * @author Hoang Minh Khuong
 */
public class liet_ke_cap_so_2_J07042 {
    public static int gcd(int a, int b){
         while (b != 0) {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public static void main(String[] args) throws Exception {
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Pair> arr = (ArrayList<Pair>) inp.readObject();
        Collections.sort(arr);
        LinkedHashSet<Pair> set = new LinkedHashSet<>();
        for(Pair x : arr){
            if(!set.contains(x)){
                if(x.getFirst() < x.getSecond() && gcd(x.getFirst(), x.getSecond()) == 1){
                    set.add(x);
                    System.out.println(x);
                }    
            }
        }
       
    }
}
