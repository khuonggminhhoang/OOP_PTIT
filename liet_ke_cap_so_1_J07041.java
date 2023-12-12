package test;

import java.io.*;
import java.util.*;

/*
 *   Note: bài này muốn ac phải nén zip
 */

/**
 *
 * @author Hoang Minh Khuong
 */
public class liet_ke_cap_so_1_J07041 {
    public static void main(String[] args) throws Exception{
        FileInputStream inpStream = new FileInputStream("DATA.in");
        ObjectInputStream inp = new ObjectInputStream(inpStream);
        ArrayList<Pair> arr = (ArrayList<Pair>) inp.readObject();
        Collections.sort(arr);
        LinkedHashSet<Pair> set = new LinkedHashSet<>();
        for(Pair x : arr){
            if(x.getFirst() < x.getSecond()) set.add(x);
        }
        for(Pair x : set){
            System.out.println(x);
        }
    }
}
