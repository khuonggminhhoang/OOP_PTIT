import java.io.*;
import java.util.*;

class Pair implements Serializable, Comparable<Pair>{
    private int first, second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
    public int getFirst(){
        return first;
    }
    public int getSecond(){
        return second;
    }
    public int compareTo(Pair o){
        return this.first - o.first;
    }
    public String toString(){
        return "(" + first + ", " + second + ")";
    }
}

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
