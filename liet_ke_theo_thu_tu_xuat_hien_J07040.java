import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class liet_ke_theo_thu_tu_xuat_hien_J07040 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        ArrayList<String> arr = (ArrayList<String>) input.readObject();

        HashSet<String> set = new HashSet<>();
        for(String x : arr){
            String[] a = x.trim().split("\\s+");
            for(String y : a){
                set.add(y.toLowerCase());
            }
        }

        Scanner scn = new Scanner(new File("VANBAN.in"));
        while(scn.hasNext()){
            String s = (scn.next()).toLowerCase();
            if(set.contains(s)){
                System.out.println(s);
                set.remove(s);
            }
        }
    }
}
